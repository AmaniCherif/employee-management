package org.acme.quartz;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.runtime.StartupEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.entity.Notification;
import org.acme.services.NotificationService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quartz.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static utils.CommonUtil.convertToDateUsingInstant;

@ApplicationScoped
@Slf4j
@NoArgsConstructor
public class TaskBean {
    @Inject
    private Scheduler quartz;
    @Inject
    private Mailer mailer;
    @RestClient
    private NotificationService notificationService;

    public void onStart(@Observes StartupEvent event) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "myGroup")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "myGroup")
                .startNow()
                //.startAt()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(10)
                                .repeatForever())
                .build();
        if (quartz.checkExists(job.getKey())) {
            quartz.deleteJob(job.getKey());
        }
        quartz.scheduleJob(job, trigger);
    }

    @Transactional
    void performTask() {
        log.info("Notification processing started");

        List<Notification> notifs = getNotifications();

        sendNotification(notifs);

        log.info("Notification processing successfully done");
    }

    private List<Notification> getNotifications() {
        return notificationService.getAllNotifications().getNotifs().stream()
                .filter(notif ->
                        notif.getDateCreat().equals(convertToDateUsingInstant(LocalDate.now()))
                                && notif.getProcessed() == 0
                )
                .collect(Collectors.toList());
    }

    private void sendNotification(List<Notification> notifs) {
        for (Notification notif : notifs) {
            Mail mail = Mail.withText("amanicherif431@gmail.com", "Mail Sent with quarkus", notif.getMessage());
            mailer.send(mail);
            notif.setProcessed(1);
            notificationService.update(notif.getIdNot(), notif);
            log.info("The notification has been sent to {}", "amanicherif431@gmail.com");
        }
    }

    public static class MyJob implements Job {
        @Inject
        TaskBean taskBean;

        public void execute(JobExecutionContext context) {
            taskBean.performTask();
        }
    }
}

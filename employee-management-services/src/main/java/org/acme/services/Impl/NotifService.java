package org.acme.services.Impl;

import org.acme.entity.Notification;
import org.acme.repository.NotificationRepository;
import org.acme.services.INotifService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class NotifService implements INotifService {
    @Inject
    private NotificationRepository notificationRepository;

    @Override
    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return (List<Notification>) notificationRepository.findAll();
    }

    @Override
    public Response update(Long id, Notification notification) {
        Optional<Notification> notifOpt = notificationRepository.findById(id);
        if (notifOpt.isPresent()) {
            Notification notif = notifOpt.get();
            notif.setProcessed(notification.getProcessed());
            Notification result = notificationRepository.save(notif);
            if (result != null) {
                return Response.ok().status(Response.Status.NO_CONTENT).build();
            }
        }
        return Response.notModified().build();
    }
}

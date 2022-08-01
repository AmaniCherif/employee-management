package org.acme.entity.listener;

import org.acme.entity.Contrat;
import org.acme.entity.Notification;
import org.acme.services.INotifService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.ZoneId;

import static utils.CommonUtil.convertToDateUsingInstant;

@ApplicationScoped
public class ContratListener {
    @Inject
    private Contrat contrat;

    @Inject
    INotifService iNotifService;

    @PrePersist
    public void prePersist(Contrat entity) {
        createNotif(entity);
    }

    private void createNotif(Contrat entity) {
        LocalDate dateFinMinus3Days = LocalDate.ofInstant(entity.getDateFin().toInstant(), ZoneId.systemDefault()).minusDays(3);

        LocalDate currentDate = LocalDate.now();

        if (dateFinMinus3Days.equals(currentDate)) {
            Notification notification = new Notification();
            String message = String.format("A notification has been sent regarding the contract n° %d", entity.getReference());
            notification.setMessage(message);

            notification.setDateCreat(convertToDateUsingInstant(currentDate));
            notification.setProcessed(0);

            iNotifService.save(notification);
        }
    }
}

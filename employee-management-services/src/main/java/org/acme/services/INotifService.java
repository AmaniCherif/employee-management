package org.acme.services;

import org.acme.entity.Notification;

import javax.ws.rs.core.Response;
import java.util.List;

public interface INotifService {
    void save(Notification notification);
     List<Notification> getAllNotifications();
    Response update(Long id, Notification notification);
}

package com.mydomain.project_server.services.site.admin;

import com.mydomain.project_server.models.MainDB.user.Notification;
import com.mydomain.project_server.repositories.MainDB.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository repo;

    public Notification getNotification(String id) {

        return repo.findById(id).get();
    }

    public List<Notification> getAllNotifications() {

        return repo.findAll();
    }

    public Notification getNotificationByUserId(String userId) {

        return repo.findNotificationByUserId(userId);
    }

    public boolean updateNotification(Notification notification) {
        repo.save(notification);
        return true;
    }

}

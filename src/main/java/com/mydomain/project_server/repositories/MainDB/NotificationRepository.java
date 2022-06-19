package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.user.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, String> {

    List<Notification> findAll();

    Notification findNotificationByUserId(String user_id);

}

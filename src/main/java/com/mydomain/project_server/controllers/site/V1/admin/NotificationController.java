package com.mydomain.project_server.controllers.site.V1.admin;


import com.mydomain.project_server.models.MainDB.user.Notification;
import com.mydomain.project_server.models.MainDB.User;
import com.mydomain.project_server.dto.site.panel.notification.NotificationForUpdateDto;
import com.mydomain.project_server.services.site.admin.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/site/admin/notification")
public class NotificationController {

    @Autowired
    NotificationService service;

    @PutMapping("{id}")
    public ResponseEntity<Object> updateNotify(@PathVariable String id, NotificationForUpdateDto notificationForUpdate) {

        var notifications = service.getNotificationByUserId(id);
        if (notifications != null) {
            //map shavad
            if (service.updateNotification(notifications)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("error in update", HttpStatus.BAD_REQUEST);
            }
        } else {
            var notification = new Notification();

            var user = new User();
            user.setId(id);
            notification.setUser(user);
            boolean res = service.updateNotification(notification);

            if (res) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("error in insert", HttpStatus.BAD_REQUEST);
            }
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Object> updateNotify(@PathVariable String id) {

        var notification = service.getNotificationByUserId(id);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not found", HttpStatus.BAD_REQUEST);
        }

    }
}

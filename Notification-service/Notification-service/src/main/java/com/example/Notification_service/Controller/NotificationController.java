package com.example.Notification_service.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/notifications/test")
    public String testNotification(@RequestParam String message) {
        return "Test notification reçue : " + message;
    }
}

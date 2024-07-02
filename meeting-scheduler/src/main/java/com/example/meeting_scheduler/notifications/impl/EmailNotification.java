package com.example.meeting_scheduler.notifications.impl;

import com.example.meeting_scheduler.notifications.INotificationObserver;
import com.example.meeting_scheduler.notifications.NotificationType;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements INotificationObserver {
    @Override
    public void sendNotification(List<String> emailList, NotificationType notificationType) {
        emailList.forEach(email->
                System.out.println("Sending "+ notificationType.name() +" notification to "+email+" via email"));
    }
}

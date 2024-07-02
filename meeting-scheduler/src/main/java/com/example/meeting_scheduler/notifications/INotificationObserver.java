package com.example.meeting_scheduler.notifications;

import java.util.List;

public interface INotificationObserver {
    void sendNotification(List<String> emailList, NotificationType notificationType);
}

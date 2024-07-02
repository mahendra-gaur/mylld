package com.example.meeting_scheduler.services;

import com.example.meeting_scheduler.model.Meeting;
import com.example.meeting_scheduler.notifications.INotificationObserver;
import com.example.meeting_scheduler.notifications.NotificationType;
import com.example.meeting_scheduler.notifications.impl.EmailNotification;
import java.util.ArrayList;
import java.util.List;


public class NotificationService {

    private final INotificationObserver notificationObserver;

    public NotificationService() {
        this.notificationObserver = new EmailNotification();
    }

    public void sendMeetingScheduledNotification(Meeting meeting) {
        List<String> emailList = new ArrayList<>();
//        List<String> emailList =                          // this also works
//                meeting.getAttendees().stream()
//                        .map( invitee -> invitee.getEmail())
//                        .filter(email-> Objects.nonNull(email)).collect(
//                        Collectors.toList());
        meeting.getAttendees().forEach( invitee -> emailList.add(invitee.getEmail()));
        this.notificationObserver.sendNotification(emailList, NotificationType.SCHEDULED);
    }

    public void sendMeetingCancelledNotification(Meeting meeting) {
        List<String> emailList = new ArrayList<>();
//        List<String> emailList =                          // this also works
//                meeting.getAttendees().stream()
//                        .map( invitee -> invitee.getEmail())
//                        .filter(email-> Objects.nonNull(email)).collect(
//                        Collectors.toList());
        meeting.getAttendees().forEach( invitee -> emailList.add(invitee.getEmail()));
        this.notificationObserver.sendNotification(emailList, NotificationType.CANCELLED);
    }

}

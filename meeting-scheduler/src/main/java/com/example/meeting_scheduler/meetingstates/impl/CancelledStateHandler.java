package com.example.meeting_scheduler.meetingstates.impl;

import com.example.meeting_scheduler.meetingstates.States;
import com.example.meeting_scheduler.meetingstates.MeetingState;
import com.example.meeting_scheduler.model.Meeting;
import com.example.meeting_scheduler.services.NotificationService;

public class CancelledStateHandler implements MeetingState {
    private final NotificationService notificationService;

    public CancelledStateHandler() {
        this.notificationService = new NotificationService();
    }

    @Override
    public void handleMeetingState(Meeting meeting) {
        meeting.setMeetingStatus(States.CANCELLED);
        System.out.println();
        this.notificationService.sendMeetingCancelledNotification(meeting);

    }
}

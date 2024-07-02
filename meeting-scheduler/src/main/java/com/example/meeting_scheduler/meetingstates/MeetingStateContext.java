package com.example.meeting_scheduler.meetingstates;

import com.example.meeting_scheduler.meetingstates.impl.ScheduledStateHandler;
import com.example.meeting_scheduler.model.Meeting;
import org.springframework.stereotype.Component;

@Component
public class MeetingStateContext {
    private MeetingState currentMeetingState;

    public MeetingStateContext() {
        this.currentMeetingState = new ScheduledStateHandler();
    }

    public void setState(MeetingState state) {
        this.currentMeetingState = state;
    }

    public void handleMeetingState(Meeting meeting) {
        this.currentMeetingState.handleMeetingState(meeting);
    }

}

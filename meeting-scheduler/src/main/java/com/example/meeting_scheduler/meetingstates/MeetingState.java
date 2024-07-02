package com.example.meeting_scheduler.meetingstates;

import com.example.meeting_scheduler.model.Meeting;

public interface MeetingState {
    void handleMeetingState(Meeting meeting);

}

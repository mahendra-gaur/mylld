package com.example.meeting_scheduler.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class User {
    @Setter
    private Integer userId;
    private String username;
    private String email;
    private List<Meeting> meetingList;
    // Other attributes and methods

    public void addMeeting(Meeting meeting) {
        this.meetingList.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        this.meetingList.removeIf( meeting1 -> meeting1.getMeetingId().equals(meeting.getMeetingId()));
    }
}

package com.example.meeting_scheduler.model;

import com.example.meeting_scheduler.meetingstates.States;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Meeting {
    @Setter
    private Integer meetingId;
    private User host;
    private List<User> attendees;
    private String title;
    private String description;
    private Interval meetingInterval;
    private MeetingRoom location;
    private boolean isRecurring;
    @Setter
    private States meetingStatus;

}

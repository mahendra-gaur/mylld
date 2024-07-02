package com.example.meeting_scheduler.services;

import com.example.meeting_scheduler.meetingstates.MeetingStateContext;
import com.example.meeting_scheduler.meetingstates.impl.CancelledStateHandler;
import com.example.meeting_scheduler.meetingstates.impl.ScheduledStateHandler;
import com.example.meeting_scheduler.model.Interval;
import com.example.meeting_scheduler.model.Meeting;
import com.example.meeting_scheduler.model.MeetingRoom;
import com.example.meeting_scheduler.model.User;
import com.example.meeting_scheduler.repositories.MeetingRepository;
import java.time.LocalDateTime;
import java.util.List;

public class MeetingService {

    private final MeetingRoomService meetingRoomService;
    private final MeetingRepository meetingRepository;
    private final MeetingStateContext ctx;

    public MeetingService() {
        this.meetingRepository = MeetingRepository.getInstance();
        this.meetingRoomService = new MeetingRoomService();
        this.ctx = new MeetingStateContext();
    }

    public Meeting createMeeting(User host, List<User> inviteeList, String title, String desc,
            LocalDateTime startTime, LocalDateTime endTime, MeetingRoom meetingRoom, boolean isRecurring) {

        // TODO 1: user validation - if user exists
        // TODO 2.1: meeting room validation - if given meeting room is available - done
        // TODO 2.2: meeting room validation - if it can accommodate all the people of inviteeList

        boolean meetingRoomAvailable = this.meetingRoomService.isAvailable(meetingRoom, startTime, endTime);
        if(!meetingRoomAvailable) {
            throw new RuntimeException("Meeting room is not available");
        }

        inviteeList.add(host);

        Interval meetingInterval = Interval.builder().startDateTime(startTime).endDateTime(endTime).build();

        Meeting meeting = Meeting.builder()
                .host(host)
                .attendees(inviteeList)
                .title(title)
                .description(desc)
                .meetingInterval(meetingInterval)
                .location(meetingRoom)
                .isRecurring(isRecurring)
                .build();

        inviteeList.forEach( invitee -> invitee.addMeeting(meeting));

        meetingRoom.addInterval(meetingInterval);

        this.ctx.setState(new ScheduledStateHandler());
        this.ctx.handleMeetingState(meeting);

        this.meetingRepository.addMeeting(meeting);

        return meeting;
    }

    public Meeting cancelMeeting(Meeting meeting) {
        List<User> userList = meeting.getAttendees();
        userList.forEach( user -> user.removeMeeting(meeting));

        Interval meetingInterval = meeting.getMeetingInterval();
        MeetingRoom meetingRoom = meeting.getLocation();
        meetingRoom.removeInterval(meetingInterval);

        this.ctx.setState(new CancelledStateHandler());
        this.ctx.handleMeetingState(meeting);

        this.meetingRepository.cancelMeeting(meeting);

        return meeting;
    }

}

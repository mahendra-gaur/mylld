package com.example.meeting_scheduler.searchmeetingroom.impl;

import com.example.meeting_scheduler.model.MeetingRoom;
import com.example.meeting_scheduler.searchmeetingroom.MeetingRoomSearchStrategy;
import java.util.List;

public class DefaultMeetingRoomSearchStrategy implements MeetingRoomSearchStrategy {
    @Override
    public List<MeetingRoom> getFilteredMeetingRooms(List<MeetingRoom> meetingRoomList, String params) {
        return meetingRoomList;
    }
}

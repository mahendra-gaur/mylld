package com.example.meeting_scheduler.searchmeetingroom;

import com.example.meeting_scheduler.model.MeetingRoom;
import java.util.List;

public interface MeetingRoomSearchStrategy {
    List<MeetingRoom> getFilteredMeetingRooms(List<MeetingRoom> meetingRoomList, String param);
}

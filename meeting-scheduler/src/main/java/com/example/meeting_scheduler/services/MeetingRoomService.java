package com.example.meeting_scheduler.services;

import com.example.meeting_scheduler.model.MeetingRoom;
import com.example.meeting_scheduler.repositories.MeetingRoomRepository;
import com.example.meeting_scheduler.searchmeetingroom.MeetingRoomSearchStrategy;
import com.example.meeting_scheduler.searchmeetingroom.impl.DefaultMeetingRoomSearchStrategy;
import java.time.LocalDateTime;
import java.util.List;


public class MeetingRoomService {
    private final MeetingRoomRepository meetingRoomRepository;
    private final MeetingRoomSearchStrategy meetingRoomSearchStrategy;

    public MeetingRoomService() {
        this.meetingRoomRepository = MeetingRoomRepository.getInstance();
        this.meetingRoomSearchStrategy = new DefaultMeetingRoomSearchStrategy();
    }
    public List<MeetingRoom> getAvailableMeetingRooms(LocalDateTime startDate, LocalDateTime endDate) {
        List<MeetingRoom> allMeetingRooms =
                this.meetingRoomRepository.getAllAvailableMeetingRooms(startDate, endDate);
        List<MeetingRoom> filteredMeetingRooms = this.meetingRoomSearchStrategy.getFilteredMeetingRooms(allMeetingRooms, null);
        return filteredMeetingRooms;
    }

    public boolean isAvailable(MeetingRoom meetingRoom, LocalDateTime startDate, LocalDateTime endDate) {
        return this.meetingRoomRepository.isAvailable(meetingRoom, startDate, endDate);
    }

    public boolean addMeetingRoom(MeetingRoom meetingRoom) {
        return this.meetingRoomRepository.addMeetingRoom(meetingRoom);
    }

}

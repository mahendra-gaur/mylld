package com.example.meeting_scheduler.repositories;

import com.example.meeting_scheduler.model.Interval;
import com.example.meeting_scheduler.model.MeetingRoom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MeetingRoomRepository {

    private final ConcurrentMap<Integer, MeetingRoom> meetingRoomMap;
    private final AtomicInteger idCounter;
    private static volatile MeetingRoomRepository INSTANCE;

    public static MeetingRoomRepository getInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (MeetingRoomRepository.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new MeetingRoomRepository();
                }
            }
        }
        return INSTANCE;
    }

    private MeetingRoomRepository() {
        this.meetingRoomMap = new ConcurrentHashMap<>();
        this.idCounter = new AtomicInteger();
    }

    public boolean addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoom.setMeetingRoomId(this.idCounter.getAndIncrement());
        this.meetingRoomMap.put(meetingRoom.getMeetingRoomId(), meetingRoom);
        return this.meetingRoomMap.containsKey(meetingRoom.getMeetingRoomId());
    }

    public List<MeetingRoom> getAllAvailableMeetingRooms(LocalDateTime startDate, LocalDateTime endDate) {
        return this.meetingRoomMap.values()
                .stream()
                .filter( room ->
                        room.getBookedIntervals()
                                .stream()
                                .noneMatch( interval -> isOverlapping(interval, startDate, endDate))
                ).collect(Collectors.toList());
    }

    private boolean isOverlapping(Interval interval, LocalDateTime start, LocalDateTime end) {
        return !interval.getEndDateTime().isBefore(start) && !interval.getStartDateTime().isAfter(end);
    }

    public boolean isAvailable(MeetingRoom meetingRoom, LocalDateTime startDate, LocalDateTime endDate) {
        List<MeetingRoom> meetingRooms = getAllAvailableMeetingRooms(startDate, endDate);
        Optional<MeetingRoom> room = meetingRooms.stream().filter(mr -> mr.getMeetingRoomId().equals(meetingRoom.getMeetingRoomId())).findFirst();
        return room.isPresent();
    }

}

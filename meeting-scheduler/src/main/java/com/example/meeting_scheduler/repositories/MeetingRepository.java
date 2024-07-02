package com.example.meeting_scheduler.repositories;

import com.example.meeting_scheduler.model.Meeting;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MeetingRepository {
    private final ConcurrentMap<Integer, Meeting> meetingConcurrentMap;
    private final ConcurrentMap<Integer, Meeting> cancelledMeetingMap;
    private final AtomicInteger idCounter;

    private static volatile MeetingRepository INSTANCE;

    public static MeetingRepository getInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (MeetingRepository.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new MeetingRepository();
                }
            }
        }
        return INSTANCE;
    }

    private MeetingRepository(){
        this.meetingConcurrentMap = new ConcurrentHashMap<>();
        this.cancelledMeetingMap = new ConcurrentHashMap<>();
        this.idCounter = new AtomicInteger();
    }

    public boolean addMeeting(Meeting meeting) {
        meeting.setMeetingId(this.idCounter.getAndIncrement());
        this.meetingConcurrentMap.put(meeting.getMeetingId(), meeting);
        return this.meetingConcurrentMap.containsKey(meeting.getMeetingId());
    }

    public boolean cancelMeeting(Meeting meeting) {
        this.meetingConcurrentMap.remove(meeting.getMeetingId());
        this.cancelledMeetingMap.put(meeting.getMeetingId(), meeting);
        return this.cancelledMeetingMap.containsKey(meeting.getMeetingId());
    }

}

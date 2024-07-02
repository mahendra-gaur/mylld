package com.example.meeting_scheduler.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Builder
public class MeetingRoom {
    @Setter
    private Integer meetingRoomId;
    private Integer seatingCapacity;
    private List<Interval> bookedIntervals;

    public void addInterval(Interval interval) {
        this.bookedIntervals.add(interval);
    }

    public void removeInterval(Interval interval) {
        this.bookedIntervals.removeIf(
                interval1 -> interval1.getStartDateTime().isEqual(interval.getStartDateTime()) &&
                        interval1.getEndDateTime().isEqual(interval.getEndDateTime()));
    }
}

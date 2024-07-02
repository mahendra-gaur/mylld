package com.example.meeting_scheduler.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Interval {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}

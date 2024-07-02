package com.example.meeting_scheduler;

import com.example.meeting_scheduler.model.Meeting;
import com.example.meeting_scheduler.model.MeetingRoom;
import com.example.meeting_scheduler.model.User;
import com.example.meeting_scheduler.services.MeetingRoomService;
import com.example.meeting_scheduler.services.MeetingService;
import com.example.meeting_scheduler.services.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MeetingScheduler {

    public static void main(String[] args) {
        UserService userService = new UserService();

        User user1 = User.builder().email("user1@abc.com").username("user1").meetingList(new ArrayList<>()).build();
        userService.addUser(user1);

        User user2 = User.builder().email("user2@abc.com").username("user2").meetingList(new ArrayList<>()).build();
        userService.addUser(user2);

        User user3 = User.builder().email("user3@abc.com").username("user3").meetingList(new ArrayList<>()).build();
        userService.addUser(user3);

        User user4 = User.builder().email("user4@abc.com").username("user4").meetingList(new ArrayList<>()).build();
        userService.addUser(user4);

        User user5 = User.builder().email("user5@abc.com").username("user5").meetingList(new ArrayList<>()).build();
        userService.addUser(user5);



        MeetingRoomService meetingRoomService = new MeetingRoomService();

        MeetingRoom meetingRoom1 = MeetingRoom.builder().seatingCapacity(5).bookedIntervals(new ArrayList<>()).build();
        meetingRoomService.addMeetingRoom(meetingRoom1);

        MeetingRoom meetingRoom2 = MeetingRoom.builder().seatingCapacity(7).bookedIntervals(new ArrayList<>()).build();
        meetingRoomService.addMeetingRoom(meetingRoom2);

        MeetingRoom meetingRoom3 = MeetingRoom.builder().seatingCapacity(3).bookedIntervals(new ArrayList<>()).build();
        meetingRoomService.addMeetingRoom(meetingRoom3);



        MeetingService meetingService = new MeetingService();
        Meeting meeting1 = meetingService.createMeeting(user1,
                new ArrayList<>() {{ add(user2); add(user3);}},
                "Meeting1 - Title",
                "Meeting1 - Description",
                LocalDateTime.of(2024, 7,2,14,30),
                LocalDateTime.of(2024, 7,2,15,00),
                meetingRoom1, false);

        // this will give exception, because we are trying to book same room with same time.
        Meeting meeting2 = meetingService.createMeeting(user1,
                new ArrayList<>() {{ add(user2); add(user3); add(user4);}},
                "Meeting2 - Title",
                "Meeting2 - Description",
                LocalDateTime.of(2024, 7,2,14,30),
                LocalDateTime.of(2024, 7,2,15,00),
                meetingRoom1, false);

        meetingService.cancelMeeting(meeting1);

        Meeting meeting3 = meetingService.createMeeting(user1,
                new ArrayList<>() {{ add(user2); add(user3); add(user4);}},
                "Meeting2 - Title",
                "Meeting2 - Description",
                LocalDateTime.of(2024, 7,2,14,30),
                LocalDateTime.of(2024, 7,2,15,00),
                meetingRoom1, false);

        System.out.println();



    }

}

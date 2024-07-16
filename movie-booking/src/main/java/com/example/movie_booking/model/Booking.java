package com.example.movie_booking.model;

import com.example.movie_booking.enums.BookingStatus;
import com.example.movie_booking.exceptions.InvalidStateException;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Booking {
    private final String id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private final String user;
    private BookingStatus bookingStatus;

    public Booking(@NonNull final String id, @NonNull final Show show, @NonNull final String user,
                   @NonNull final List<Seat> seatsBooked) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException();
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }
}

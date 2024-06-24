package com.example.locker.controller;

import com.example.locker.model.Buyer;
import com.example.locker.model.DeliveryPerson;
import com.example.locker.model.LockerItem;
import com.example.locker.model.Slot;
import com.example.locker.service.DeliveryPersonService;
import com.example.locker.service.LockerService;
import com.example.locker.service.NotificationService;
import com.example.locker.service.OtpService;
import lombok.NonNull;

public class ReturnController {

    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;
    private final DeliveryPersonService deliveryPersonService;

    public ReturnController(@NonNull final NotificationService notificationService,
            @NonNull final OtpService otpService,
            @NonNull final LockerService lockerService,
            @NonNull final DeliveryPersonService deliveryPersonService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.deliveryPersonService = deliveryPersonService;
    }

    public void allocateLocker(@NonNull final LockerItem lockerItem) {
        final Slot slot = lockerService.allocateSlot(lockerItem);
        final String otp = otpService.generateOtp(slot);
        final DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(slot);
        notificationService.notifyUser(deliveryPerson, otp, slot);
    }
}
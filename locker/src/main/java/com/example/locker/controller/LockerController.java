package com.example.locker.controller;

import com.example.locker.model.Locker;
import com.example.locker.model.Size;
import com.example.locker.model.Slot;
import com.example.locker.service.LockerService;
import com.example.locker.service.OtpService;
import java.util.List;
import lombok.NonNull;

public class LockerController {

    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(@NonNull final LockerService lockerService,
            @NonNull final OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(@NonNull final String lockerId) {
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(@NonNull final Locker locker, @NonNull final Size slotSize) {
        return lockerService.createSlot(locker, slotSize);
    }

    public List<Slot> getAvailableSlots() {
        return lockerService.getAllAvailableSlots();
    }

    public boolean unlockSlot(@NonNull final Slot slot, @NonNull final String otp) {
        return otpService.validateOtp(slot, otp);
        // Post validation of otp, some physical entity will open the actual slot.
    }

    public void deallocateSlot(@NonNull final Slot slot) {
        lockerService.deallocateSlot(slot);
    }
}

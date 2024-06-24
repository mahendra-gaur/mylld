package com.example.locker.utils;

import static com.example.locker.utils.RandomUtils.randomString;

import com.example.locker.controller.LockerController;
import com.example.locker.model.Package;
import com.example.locker.model.Locker;
import com.example.locker.model.LockerItem;
import com.example.locker.model.Size;
import com.example.locker.model.Slot;

public class LockerUtils {

    public static Locker createTestLockerWithSlots(LockerController lockerController, Integer numSlots, Size slotSize) {
        final Locker locker = lockerController.createLocker(randomString());
        for (int i = 0; i < numSlots; i++) {
            final Slot slot1 = lockerController.createSlot(locker, slotSize);
        }
        return locker;
    }

    public static LockerItem randomLockerItem(Size itemSize) {
        return new Package(randomString(), itemSize);
    }
}
package com.example.locker.repository;

import com.example.locker.model.Locker;
import com.example.locker.model.Slot;
import java.util.List;
import lombok.NonNull;

public interface ILockerRepository {

    @NonNull
    Locker createLocker(@NonNull String id);

    @NonNull
    List<Slot> getAllAvailableSlots();
}
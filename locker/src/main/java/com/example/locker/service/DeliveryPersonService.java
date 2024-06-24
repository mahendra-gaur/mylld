package com.example.locker.service;

import com.example.locker.model.DeliveryPerson;
import com.example.locker.model.Slot;
import lombok.NonNull;

public class DeliveryPersonService {

    @NonNull
    public DeliveryPerson getDeliveryPerson(@NonNull final Slot slot) {
        // TODO: Use some strategy here to pick a delivery person.
        return null;
    }
}
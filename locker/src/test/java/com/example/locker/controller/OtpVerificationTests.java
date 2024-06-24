package com.example.locker.controller;

import static com.example.locker.utils.BuyerUtils.randomBuyer;
import static com.example.locker.utils.RandomUtils.randomOtp;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.example.locker.model.Buyer;
import com.example.locker.model.LockerItem;
import com.example.locker.model.Size;
import com.example.locker.model.Slot;
import com.example.locker.utils.LockerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OtpVerificationTests extends BaseTest {

    @Test
    public void testOtpWorksCorrectly() {

        // Arrange
        LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
        final Buyer buyer = randomBuyer();
        final LockerItem item = LockerUtils.randomLockerItem(new Size(5.0, 5.0));

        // Act
        final Slot slot = orderController.allocateLocker(buyer, item);

        // Assert
        ArgumentCaptor<String> otpCaptor = ArgumentCaptor.forClass(String.class);
        verify(notificationService).notifyUser(eq(buyer), otpCaptor.capture(), eq(slot));
        final String otp = otpCaptor.getValue();
        assertNotNull(otp);
        boolean isSuccess = lockerController.unlockSlot(slot, otp);

        assertTrue(isSuccess);
    }

    @Test
    public void testInvalidOtpDoesNotUnlocksSlot() {

        // Arrange
        LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
        final Buyer buyer = randomBuyer();
        final LockerItem item = LockerUtils.randomLockerItem(new Size(5.0, 5.0));

        // Act
        final Slot slot = orderController.allocateLocker(buyer, item);

        // Assert
        boolean isSuccess = lockerController.unlockSlot(slot, randomOtp());

        assertFalse(isSuccess);
    }
}
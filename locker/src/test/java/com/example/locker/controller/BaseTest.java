package com.example.locker.controller;

import com.example.locker.repository.ILockerRepository;
import com.example.locker.repository.impl.LockerRepositoryInMemory;
import com.example.locker.repository.impl.SlotOtpRepositoryInMemory;
import com.example.locker.service.LockerService;
import com.example.locker.service.NotificationService;
import com.example.locker.service.OtpService;
import com.example.locker.strategies.ISlotAssignmentStrategy;
import com.example.locker.strategies.ISlotFilteringStrategy;
import com.example.locker.strategies.impl.OtpGeneratorRandom;
import com.example.locker.strategies.impl.RandomGeneratorDefault;
import com.example.locker.strategies.impl.SlotAssignmentStrategyRandom;
import com.example.locker.strategies.impl.SlotFilteringStrategySizeBased;
import org.junit.Before;
import org.mockito.Mock;

public class BaseTest {

    protected LockerController lockerController;
    protected OrderController orderController;
    protected OtpService otpService;
    protected LockerService lockerService;

    @Mock
    protected NotificationService notificationService;

    @Before
    public void setup() {

        final RandomGeneratorDefault randomGeneratorDefault = new RandomGeneratorDefault();
        final ISlotAssignmentStrategy lockerAssignmentStrategy = new SlotAssignmentStrategyRandom(randomGeneratorDefault);
        final ILockerRepository lockerRepository = new LockerRepositoryInMemory();
        final ISlotFilteringStrategy slotFilteringStrategy = new SlotFilteringStrategySizeBased();
        final SlotOtpRepositoryInMemory slotOtpRepository = new SlotOtpRepositoryInMemory();
        final OtpGeneratorRandom otpGeneratorRandom = new OtpGeneratorRandom(5, randomGeneratorDefault);

        this.lockerService = new LockerService(lockerAssignmentStrategy, lockerRepository, slotFilteringStrategy);
        this.otpService = new OtpService(otpGeneratorRandom, slotOtpRepository);

        this.lockerController = new LockerController(lockerService, otpService);
        this.orderController = new OrderController(notificationService, otpService, lockerService);
    }
}
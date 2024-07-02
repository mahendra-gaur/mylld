package com.example.meeting_scheduler.repositories;

import com.example.meeting_scheduler.model.User;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    private final ConcurrentMap<String, User> userConcurrentMap;
    private final AtomicInteger idCounter;
    private static volatile UserRepository INSTANCE;

    public static UserRepository getInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (UserRepository.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new UserRepository();
                }
            }
        }
        return INSTANCE;
    }

    private UserRepository(){
        this.userConcurrentMap = new ConcurrentHashMap<>();
        this.idCounter = new AtomicInteger();
    }

    public boolean addUser(User user) {
        user.setUserId(this.idCounter.getAndIncrement());
        this.userConcurrentMap.put(user.getEmail(), user);
        return this.userConcurrentMap.containsKey(user.getEmail());
    }

    public User getUserByEmail(String email) {
        return this.userConcurrentMap.get(email);
    }

}

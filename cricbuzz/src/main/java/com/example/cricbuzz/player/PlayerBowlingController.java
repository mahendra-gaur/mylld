package com.example.cricbuzz.player;

import lombok.Getter;
import lombok.NonNull;

import java.util.*;

public class PlayerBowlingController {
    private final Deque<PlayerDetails> bowlersList;
    private final Map<PlayerDetails, Integer> bowlerVsOverCount;
    @Getter private PlayerDetails currentBowler;

    public PlayerBowlingController(@NonNull final List<PlayerDetails> bowlers) {
        this.bowlersList = new LinkedList<>();
        this.bowlerVsOverCount = new HashMap<>();
        for (PlayerDetails bowler : bowlersList) {
            this.bowlersList.addLast(bowler);
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(@NonNull final Integer maxOverCountPerBowler) {

        PlayerDetails playerDetails = bowlersList.poll();
        if(bowlerVsOverCount.get(playerDetails)+1 == maxOverCountPerBowler) {
            currentBowler = playerDetails;
        }
        else {
            currentBowler = playerDetails;
            bowlersList.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }
    }


}

package com.example.cricbuzz.player;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    private final Queue<PlayerDetails> yetToPlay;

    @Getter @Setter private PlayerDetails striker;

    @Getter @Setter private PlayerDetails nonStriker;

    public PlayerBattingController(@NonNull final Queue<PlayerDetails> playing11) {
        this.yetToPlay = new LinkedList<>();
        this.yetToPlay.addAll(playing11);
    }

    public void getNextPlayer() throws Exception {

        if (yetToPlay.isEmpty()) {
            throw new Exception();
        }

        if (striker == null) {
            striker = yetToPlay.poll();
        }

        if (nonStriker == null) {
            nonStriker = yetToPlay.poll();
        }
    }


}

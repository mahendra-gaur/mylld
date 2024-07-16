package com.example.cricbuzz.team;

import com.example.cricbuzz.player.PlayerBattingController;
import com.example.cricbuzz.player.PlayerBowlingController;
import com.example.cricbuzz.player.PlayerDetails;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Queue;

public class Team {
    @Getter
    private String teamName;
    public Queue<PlayerDetails> playing11;
    public List<PlayerDetails> bench;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;
    public boolean isWinner;

    public Team(@NonNull final String teamName, @NonNull final Queue<PlayerDetails> playing11,
                @NonNull final List<PlayerDetails> bench, @NonNull final List<PlayerDetails> bowlers){
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        battingController = new PlayerBattingController(playing11);
        bowlingController = new PlayerBowlingController(bowlers);
    }

    public void chooseNextBatsMan() throws Exception{
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(@NonNull final Integer maxOverCountPerBowler){
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public PlayerDetails getStriker() {
        return battingController.getStriker();
    }

    public PlayerDetails getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setStriker(@NonNull final PlayerDetails player) {
        battingController.setStriker(player);
    }

    public void setNonStriker(@NonNull final PlayerDetails player) {
        battingController.setNonStriker(player);
    }

    public PlayerDetails getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard(){

        for(PlayerDetails playerDetails : playing11){
            playerDetails.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){

        for(PlayerDetails playerDetails : playing11){
            if(playerDetails.getBowlingScoreCard().getTotalOversCount() > 0) {
                playerDetails.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns(){
        int totalRun=0;
        for (PlayerDetails player :  playing11){

            totalRun+=player.getBattingScoreCard().getTotalRuns();
        }
        return totalRun;
    }


}

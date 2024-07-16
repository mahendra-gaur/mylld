package com.example.cricbuzz.player;

import com.example.cricbuzz.enums.PlayerType;
import com.example.cricbuzz.scores.BattingScoreCard;
import com.example.cricbuzz.scores.BowlingScoreCard;
import lombok.Getter;
import lombok.NonNull;

public class PlayerDetails extends Person{
//    private final Person person;
    private final PlayerType playerType;
    @Getter
    private final BattingScoreCard battingScoreCard;
    @Getter
    private final BowlingScoreCard bowlingScoreCard;

    public PlayerDetails(@NonNull final String playerName, @NonNull final PlayerType playerType){
        super(playerName);
        this.playerType = playerType;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }

    public void printBattingScoreCard(){

        System.out.println("PlayerName: " + getName()
                + " -- totalRuns: " + battingScoreCard.getTotalRuns()
                + " -- totalBallsPlayed: " + battingScoreCard.getTotalBallsPlayed()
                + " -- 4s: " + battingScoreCard.getTotalFours()
                + " -- 6s: " + battingScoreCard.getTotalSix()
                + " -- outby: " + ((battingScoreCard.getWicketDetails() != null) ?
                                        battingScoreCard.getWicketDetails().getTakenBy().getName()
                                        : "notout")
        );
    }

    public void printBowlingScoreCard(){
        System.out.println("PlayerName: " + getName()
                + " -- totalOversThrown: " + bowlingScoreCard.getTotalOversCount()
                + " -- totalRunsGiven: " + bowlingScoreCard.getRunsGiven()
                + " -- WicketsTaken: " + bowlingScoreCard.getWicketsTaken());
    }


}

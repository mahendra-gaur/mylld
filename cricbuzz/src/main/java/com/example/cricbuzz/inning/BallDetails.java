package com.example.cricbuzz.inning;

import com.example.cricbuzz.enums.BallType;
import com.example.cricbuzz.enums.RunType;
import com.example.cricbuzz.enums.WicketType;
import com.example.cricbuzz.player.PlayerDetails;
import com.example.cricbuzz.scoreupdater.ScoreUpdaterObserver;
import com.example.cricbuzz.scoreupdater.impl.BattingScoreUpdater;
import com.example.cricbuzz.scoreupdater.impl.BowlingScoreUpdater;
import com.example.cricbuzz.team.Team;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    @Getter
    private final Integer ballNumber;

    @Getter
    private BallType ballType;

    @Getter
    private RunType runType;


    @Getter
    private PlayerDetails playedBy;
    @Getter
    private PlayerDetails bowledBy;

    @Getter
    private Wicket wicket;
    private final List<ScoreUpdaterObserver> scoreUpdaterObserverList;

    public BallDetails(@NonNull final Integer ballNumber) {
        this.ballNumber = ballNumber;
        this.scoreUpdaterObserverList = new ArrayList<>();
        this.scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        this.scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startBallDelivery(@NonNull final Team battingTeam, @NonNull final Team bowlingTeam,
                                  @NonNull final OverDetails over) {

        playedBy = battingTeam.getStriker();
        this.bowledBy = over.getBowledBy();
        //THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always NORMAL
        ballType = BallType.NORMAL;

        //wicket or no wicket
        if (isWicketTaken()) {
            runType = RunType.ZERO;
            //considering only BOLD
            wicket = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over,this);
            //making only striker out for now
            battingTeam.setStriker(null);
        } else {
            runType = getRun();

            if(runType == RunType.ONE || runType == RunType.THREE) {
                //swap striket and non striker
                PlayerDetails temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

        //update player scoreboard
        notifyUpdaters(this);
    }

    private void notifyUpdaters(BallDetails ballDetails){

        for(ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(ballDetails);
        }
    }

    private RunType getRun() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        //random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }


}

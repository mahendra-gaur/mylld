package com.example.cricbuzz.scoreupdater.impl;

import com.example.cricbuzz.enums.RunType;
import com.example.cricbuzz.inning.BallDetails;
import com.example.cricbuzz.scoreupdater.ScoreUpdaterObserver;
import lombok.NonNull;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void update(@NonNull final BallDetails ballDetails) {
        int run = 0;

        if (RunType.ONE == ballDetails.getRunType()) {
            run = 1;
        } else if (RunType.TWO == ballDetails.getRunType()) {
            run = 2;
        } else if (RunType.FOUR == ballDetails.getRunType()) {
            run = 4;
            ballDetails.getPlayedBy().getBattingScoreCard().setTotalFours(
                    ballDetails.getPlayedBy().getBattingScoreCard().getTotalFours()+1);
        } else if (RunType.SIX == ballDetails.getRunType()) {
            run = 6;
            ballDetails.getPlayedBy().getBattingScoreCard().setTotalSix(
                    ballDetails.getPlayedBy().getBattingScoreCard().getTotalSix()+1);
        }
        ballDetails.getPlayedBy().getBattingScoreCard().setTotalRuns(
                ballDetails.getPlayedBy().getBattingScoreCard().getTotalRuns() + run);

        ballDetails.getPlayedBy().getBattingScoreCard().setTotalBallsPlayed(
                ballDetails.getPlayedBy().getBattingScoreCard().getTotalBallsPlayed()+1);

        if (ballDetails.getWicket() != null) {
            ballDetails.getPlayedBy().getBattingScoreCard().setWicketDetails(ballDetails.getWicket());
        }
    }

}
package com.example.cricbuzz.scoreupdater.impl;

import com.example.cricbuzz.enums.BallType;
import com.example.cricbuzz.enums.RunType;
import com.example.cricbuzz.inning.BallDetails;
import com.example.cricbuzz.scoreupdater.ScoreUpdaterObserver;
import lombok.NonNull;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {

    @Override
    public void update(@NonNull final BallDetails ballDetails) {

        if (ballDetails.getBallNumber() == 6 && ballDetails.getBallType() == BallType.NORMAL) {
            ballDetails.getBowledBy().getBowlingScoreCard().setTotalOversCount(
                    ballDetails.getBowledBy().getBowlingScoreCard().getTotalOversCount()+1);
        }

        if (RunType.ONE == ballDetails.getRunType()) {
            ballDetails.getBowledBy().getBowlingScoreCard().setRunsGiven(
                    ballDetails.getBowledBy().getBowlingScoreCard().getRunsGiven()+1);
        } else if (RunType.TWO == ballDetails.getRunType()) {
            ballDetails.getBowledBy().getBowlingScoreCard().setRunsGiven(
                    ballDetails.getBowledBy().getBowlingScoreCard().getRunsGiven()+2);
        } else if (RunType.FOUR == ballDetails.getRunType()) {
            ballDetails.getBowledBy().getBowlingScoreCard().setRunsGiven(
                    ballDetails.getBowledBy().getBowlingScoreCard().getRunsGiven()+4);
        } else if (RunType.SIX == ballDetails.getRunType()) {
            ballDetails.getBowledBy().getBowlingScoreCard().setRunsGiven(
                    ballDetails.getBowledBy().getBowlingScoreCard().getRunsGiven()+6);
        }

        if (ballDetails.getWicket() != null) {
            ballDetails.getBowledBy().getBowlingScoreCard().setWicketsTaken(
                    ballDetails.getBowledBy().getBowlingScoreCard().getWicketsTaken()+1);
        }

        if (ballDetails.getBallType() == BallType.NOBALL) {
            ballDetails.getBowledBy().getBowlingScoreCard().setNoBallCount(
                    ballDetails.getBowledBy().getBowlingScoreCard().getNoBallCount()+1);
        }

        if (ballDetails.getBallType() == BallType.WIDEBALL) {
            ballDetails.getBowledBy().getBowlingScoreCard().setWideBallCount(
                    ballDetails.getBowledBy().getBowlingScoreCard().getWideBallCount()+1);
        }
    }

}
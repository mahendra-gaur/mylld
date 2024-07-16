package com.example.cricbuzz.inning;

import com.example.cricbuzz.enums.BallType;
import com.example.cricbuzz.player.PlayerDetails;
import com.example.cricbuzz.team.Team;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class OverDetails {
    private final Integer overNumber;
    private final List<BallDetails> balls;
    @Getter
    private final PlayerDetails bowledBy;
    private Integer extraBallsCount;

    public OverDetails(@NonNull final Integer overNumber, @NonNull final PlayerDetails bowledBy){
        this.overNumber = overNumber;
        this.balls = new ArrayList<>();
        this.bowledBy = bowledBy;
    }

    public boolean startOver(@NonNull final Team battingTeam, @NonNull final Team bowlingTeam,
                             @NonNull final Integer runsToWin) throws Exception{

        int ballCount = 1;
        while(ballCount<=6){

            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.getBallType() == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if(ball.getWicket() != null) {
                    battingTeam.chooseNextBatsMan();
                }

                if( runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin){
                    battingTeam.isWinner = true;
                    return true;
                }
            }
            else {
                extraBallsCount++;
            }
        }

        return false;
    }



}

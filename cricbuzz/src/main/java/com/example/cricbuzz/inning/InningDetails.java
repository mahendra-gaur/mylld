package com.example.cricbuzz.inning;

import com.example.cricbuzz.matchtype.MatchType;
import com.example.cricbuzz.player.PlayerDetails;
import com.example.cricbuzz.team.Team;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class InningDetails {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private final MatchType matchType;
    private final List<OverDetails> overs;

    public InningDetails(@NonNull final Team battingTeam, @NonNull final Team bowlingTeam,
                         @NonNull final MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void start(@NonNull final Integer runsToWin){

        //set batting players
        try {
            battingTeam.chooseNextBatsMan();
        }catch (Exception e) {

        }

        int noOfOvers = matchType.noOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {

            //chooseBowler
            bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());

            OverDetails over = new OverDetails(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won == true) {
                    break;
                }
            }catch (Exception e) {
                break;
            }

            //swap striket and non striker
            PlayerDetails temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }


}

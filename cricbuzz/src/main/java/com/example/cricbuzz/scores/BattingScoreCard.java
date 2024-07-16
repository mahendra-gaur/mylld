package com.example.cricbuzz.scores;

import com.example.cricbuzz.inning.Wicket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BattingScoreCard {
    private int totalRuns;
    private int totalBallsPlayed;
    private int totalFours;
    private int totalSix;
    private double strikeRate;
    private Wicket wicketDetails;
}

package com.example.cricbuzz.scores;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BowlingScoreCard {
    private Integer totalOversCount;
    private Integer runsGiven;
    private Integer wicketsTaken;
    private Integer noBallCount;
    private Integer wideBallCount;
    private Double economyRate;
}

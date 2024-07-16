package com.example.cricbuzz.inning;

import com.example.cricbuzz.enums.WicketType;
import com.example.cricbuzz.player.PlayerDetails;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Wicket {
    private final WicketType wicketType;
    @Getter
    private final PlayerDetails takenBy;
    private final OverDetails overDetail;
    private final BallDetails ballDetail;

}

package com.example.cricbuzz.scoreupdater;

import com.example.cricbuzz.inning.BallDetails;
import lombok.NonNull;

public interface ScoreUpdaterObserver {
    void update(@NonNull final BallDetails ballDetails);
}

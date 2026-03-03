package org.example.service;

import org.example.domain.Mission;

public class AdvancedMissionValidatorService implements MissionValidatorService{
    @Override
    public boolean validate(Mission mission) {
        return mission.getDifficulty() % 2 == 0;
    }
}

package org.example.application;

import org.example.domain.Mission;
import org.example.domain.Player;
import org.example.service.AdvancedMissionValidatorService;
import org.example.service.BasicMissionValidatorService;

public class GameEngine {

    private BasicMissionValidatorService basic_validator;
    private AdvancedMissionValidatorService advanced_validator;

    public GameEngine() {
        this.basic_validator = new BasicMissionValidatorService();
        this.advanced_validator = new AdvancedMissionValidatorService();
    }

    public boolean executeMission(Player player, Mission mission) {

        boolean basic_success = basic_validator.validate(mission);
        boolean advanced_success = advanced_validator.validate(mission);

        if (basic_success && advanced_success) {
            player.addScore(mission.getDifficulty() * 10);
            return true;
        }

        player.addScore(-5);
        return false;
    }
}

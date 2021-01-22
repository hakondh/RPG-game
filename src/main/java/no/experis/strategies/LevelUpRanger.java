package main.java.no.experis.strategies;

import main.java.no.experis.HeroStats;
import main.java.no.experis.constants.RangerConstants;

public class LevelUpRanger implements LevelUpStrategy{
    public void levelUp(HeroStats heroStats) {
        heroStats.setHealth(heroStats.getHealth() + RangerConstants.LEVEL_UP_HP_GAIN);
        heroStats.setStrength(heroStats.getStrength() + RangerConstants.LEVEL_UP_STR_GAIN);
        heroStats.setDexterity(heroStats.getDexterity() + RangerConstants.LEVEL_UP_DEX_GAIN);
        heroStats.setIntelligence(heroStats.getIntelligence() + RangerConstants.LEVEL_UP_INT_GAIN);
    }
}

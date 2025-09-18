package main.java.no.experis.hero.strategies;

import main.java.no.experis.hero.ActorStats;
import main.java.no.experis.constants.RangerConstants;

public class LevelUpRanger implements LevelUpStrategy{
    public void levelUp(ActorStats heroStats) {
        heroStats.setHealth(heroStats.getBaseHealth() + RangerConstants.LEVEL_UP_HP_GAIN);
        heroStats.setStrength(heroStats.getStrength() + RangerConstants.LEVEL_UP_STR_GAIN);
        heroStats.setDexterity(heroStats.getDexterity() + RangerConstants.LEVEL_UP_DEX_GAIN);
        heroStats.setIntelligence(heroStats.getIntelligence() + RangerConstants.LEVEL_UP_INT_GAIN);
    }
}

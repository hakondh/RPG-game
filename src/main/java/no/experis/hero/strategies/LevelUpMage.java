package main.java.no.experis.hero.strategies;

import main.java.no.experis.hero.HeroStats;
import main.java.no.experis.constants.MageConstants;

public class LevelUpMage implements LevelUpStrategy{
    public void levelUp(HeroStats heroStats) {
        heroStats.setHealth(heroStats.getHealth() + MageConstants.LEVEL_UP_HP_GAIN);
        heroStats.setStrength(heroStats.getStrength() + MageConstants.LEVEL_UP_STR_GAIN);
        heroStats.setDexterity(heroStats.getDexterity() + MageConstants.LEVEL_UP_DEX_GAIN);
        heroStats.setIntelligence(heroStats.getIntelligence() + MageConstants.LEVEL_UP_INT_GAIN);
    }
}

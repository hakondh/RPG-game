package main.java.no.experis.hero.strategies;

import main.java.no.experis.hero.HeroStats;
import main.java.no.experis.constants.WarriorConstants;

public class LevelUpWarrior implements LevelUpStrategy {
    public void levelUp(HeroStats heroStats) {
        heroStats.setHealth(heroStats.getHealth() + WarriorConstants.LEVEL_UP_HP_GAIN);
        heroStats.setStrength(heroStats.getStrength() + WarriorConstants.LEVEL_UP_STR_GAIN);
        heroStats.setDexterity(heroStats.getDexterity() + WarriorConstants.LEVEL_UP_DEX_GAIN);
        heroStats.setIntelligence(heroStats.getIntelligence() + WarriorConstants.LEVEL_UP_INT_GAIN);
    }
}

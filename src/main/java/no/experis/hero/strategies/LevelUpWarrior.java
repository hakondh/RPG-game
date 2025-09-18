package main.java.no.experis.hero.strategies;

import main.java.no.experis.constants.WarriorConstants;
import main.java.no.experis.hero.ActorStats;

public class LevelUpWarrior implements LevelUpStrategy {
	public void levelUp(ActorStats actorStats) {
		actorStats.setHealth(actorStats.getBaseHealth() + WarriorConstants.LEVEL_UP_HP_GAIN);
		actorStats.setStrength(actorStats.getStrength() + WarriorConstants.LEVEL_UP_STR_GAIN);
		actorStats.setDexterity(actorStats.getDexterity() + WarriorConstants.LEVEL_UP_DEX_GAIN);
		actorStats.setIntelligence(actorStats.getIntelligence() + WarriorConstants.LEVEL_UP_INT_GAIN);
	}
}

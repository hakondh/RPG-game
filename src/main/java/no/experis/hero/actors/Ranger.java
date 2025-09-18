package main.java.no.experis.hero.actors;

import main.java.no.experis.constants.RangerConstants;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.ActorStats;
import main.java.no.experis.hero.strategies.LevelUpRanger;

public class Ranger extends Actor {
	public Ranger(String name) {
		super(name, ActorClass.RANGER, new ActorStats(RangerConstants.START_HP, RangerConstants.START_STR,
				RangerConstants.START_DEX, RangerConstants.START_INT), new LevelUpRanger());
	}
}

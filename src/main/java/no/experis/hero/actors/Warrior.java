package main.java.no.experis.hero.actors;

import main.java.no.experis.constants.WarriorConstants;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.ActorStats;
import main.java.no.experis.hero.strategies.LevelUpWarrior;

public class Warrior extends Actor {

	public Warrior(String name) {
		super(name, ActorClass.WARRIOR, new ActorStats(WarriorConstants.START_HP, WarriorConstants.START_STR,
				WarriorConstants.START_DEX, WarriorConstants.START_INT), new LevelUpWarrior());
	}
}

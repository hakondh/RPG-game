package main.java.no.experis.hero.actors;

import main.java.no.experis.constants.MageConstants;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.ActorStats;
import main.java.no.experis.hero.strategies.LevelUpMage;

public class Mage extends Actor {
	public Mage(String name) {
		super(name, ActorClass.MAGE, new ActorStats(MageConstants.START_HP, MageConstants.START_STR,
				MageConstants.START_DEX, MageConstants.START_INT), new LevelUpMage());
	}
}

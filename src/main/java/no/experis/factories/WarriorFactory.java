package main.java.no.experis.factories;

import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.actors.Warrior;

public class WarriorFactory implements IActorFactory {
	public Actor createActor(String name) {
		return new Warrior(name);
	}

	public ActorClass getActorClass() {
		return ActorClass.WARRIOR;
	}
}

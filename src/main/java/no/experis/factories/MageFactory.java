package main.java.no.experis.factories;

import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.actors.Mage;

public class MageFactory implements IActorFactory {
	public Actor createActor(String name) {
		return new Mage(name);
	}

	public ActorClass getActorClass() {
		return ActorClass.MAGE;
	}
}
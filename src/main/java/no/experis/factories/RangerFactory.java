package main.java.no.experis.factories;

import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.actors.Ranger;

public class RangerFactory implements IActorFactory {
	public Actor createActor(String name) {
		return new Ranger(name);
	}

	public ActorClass getActorClass() {
		return ActorClass.RANGER;
	}
}
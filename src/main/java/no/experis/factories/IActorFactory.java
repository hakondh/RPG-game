package main.java.no.experis.factories;

import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;

public interface IActorFactory {
	Actor createActor(String name);

	ActorClass getActorClass();
}

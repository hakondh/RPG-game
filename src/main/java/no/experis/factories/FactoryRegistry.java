package main.java.no.experis.factories;

import java.util.HashMap;
import java.util.Map;

import main.java.no.experis.hero.ActorClass;

public class FactoryRegistry {
	private static FactoryRegistry instance;
	private final Map<ActorClass, IActorFactory> factories = new HashMap<>();

	private FactoryRegistry() {
	}

	public static synchronized FactoryRegistry getInstance() {
		if (instance == null) {
			instance = new FactoryRegistry();
		}

		return instance;
	}

	public void registerFactory(IActorFactory factory) {
		factories.put(factory.getActorClass(), factory);
	}

	public IActorFactory getFactory(ActorClass actorClass) {
		var factory = factories.get(actorClass);

		if (factory == null) {
			throw new IllegalArgumentException("No factory for class " + actorClass);
		}

		return factory;
	}
}

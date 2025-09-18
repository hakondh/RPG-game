package main.java.no.experis.game;

import java.io.IOException;

import main.java.no.experis.config.GameConfig;
import main.java.no.experis.factories.FactoryRegistry;
import main.java.no.experis.factories.MageFactory;
import main.java.no.experis.factories.RangerFactory;
import main.java.no.experis.factories.WarriorFactory;

public class Main {
	public static void main(String[] args) {
		try {
			GameConfig.load();
		} catch (IOException exception) {
			System.out.println("Something went wrong reading the config file");
			System.out.print(exception.getMessage());
		}

		// Register the actor factories we want
		FactoryRegistry registry = FactoryRegistry.getInstance();
		registry.registerFactory(new WarriorFactory());
		registry.registerFactory(new RangerFactory());
		registry.registerFactory(new MageFactory());

		new RolePlayingGame().execute();
	}
}

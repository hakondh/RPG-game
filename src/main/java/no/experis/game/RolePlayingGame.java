package main.java.no.experis.game;

import main.java.no.experis.helpers.PrintHelper;

public class RolePlayingGame {
	public void execute() {
		PrintHelper.printTitle("=== Welcome to the RPG ===");

		var hero = new CharacterCreation().execute();

		PrintHelper.printTitle(hero.getName() + "... start your journey.");

		new OnTheRoad().execute(hero);
	}
}

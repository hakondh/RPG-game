package main.java.no.experis.game;

import java.util.Random;

import Enemies.Enemies;
import Enums.BattleResult;
import main.java.no.experis.battles.TypingBattle;
import main.java.no.experis.helpers.PrintHelper;
import main.java.no.experis.hero.Actor;

public class OnTheRoad {
	private Random random = new Random();

	public void execute(Actor hero) {
		var enemies = new Enemies().GetEnemies();

		int day = 0;
		while (day < 10) {
			PrintHelper.printDialog("You walk North...");

			if (random.nextBoolean()) { // 50% chance of encounter
				var enemy = enemies.get(day);

				PrintHelper.printDialog("An enemy appears!");
				PrintHelper.printTitle(enemy.getName());
				enemy.displayStats();

				var battleResult = new TypingBattle().Start(hero, enemy);

				if (battleResult == BattleResult.Lost) {
					PrintHelper.printTitle("You died");
					break;
				}

				if (battleResult == BattleResult.Won) {
					PrintHelper.printDialog(enemy.getName() + " has died!");
					PrintHelper.printDialog("You defeated " + enemy.getName() + "!");
					hero.giveXp(200).apply();

				}

				if (battleResult == BattleResult.Draw) {
					PrintHelper.printDialog("The Battle is over. You part ways with the Enemy.");
				}

				day++;
			}
		}
	}
}

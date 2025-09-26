package main.java.no.experis.battles;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import main.java.no.experis.enums.BattleResult;
import main.java.no.experis.helpers.PrintHelper;
import main.java.no.experis.hero.Actor;

public class TypingBattle {
	private Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
	private final List<String> sentences = List.of("Bright stars shimmered gently across the calm midnight sky",
			"Quiet rivers flow softly beneath the glowing silver moon",
			"Children laugh freely while chasing butterflies through sunny fields",
			"Ancient trees whispered secrets of forgotten times and dreams",
			"Golden sands glisten warmly under the blazing summer sun",
			"Soft music drifted peacefully through the candlelit evening air",
			"Fresh morning dew sparkled brightly on the green garden leaves",
			"Distant thunder echoed across valleys under darkening evening clouds",
			"Waves crashed rhythmically against rugged cliffs by the lighthouse",
			"Gentle rain kissed the earth, calming restless wandering spirits");

	public BattleResult Start(Actor hero, Actor enemy) {
		PrintHelper.printTitle("Get ready to type the following sentence as fast as you can!");

		var round = 0;
		while (round < 3) {
			var playerWon = executeTypingBattle(hero, enemy);

			if (playerWon) {
				hero.attack(enemy);
				enemy.displayStats();
			} else {
				enemy.attack(hero);
				hero.displayStats();
			}

			// Has any of the characters died?

			if (hero.getHp() == 0) {
				return BattleResult.Lost;
			}

			if (enemy.getHp() == 0) {
				// TODO: Make it possible for an enemy to drop an item (to equip)?
				return BattleResult.Won;
			}

			round++;
		}

		return BattleResult.Draw;
	}

	private boolean executeTypingBattle(Actor hero, Actor enemy) {
		String sentence = sentences.get(rand.nextInt(10));
		PrintHelper.printDialog("\"" + sentence + "\"");

		final int seconds = 13; // total countdown seconds
		AtomicBoolean typingFinished = new AtomicBoolean(false);

		// Countdown thread
		Thread countdownThread = new Thread(() -> {
			for (int i = seconds; i >= 0 && !typingFinished.get(); i--) {
				System.out.print("\rTime left: " + i + "s "); // \r rewinds to start of line
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {
					return;
				}
			}
		});
		countdownThread.start();

		long start = System.currentTimeMillis();
		String input = scanner.nextLine(); // blocks until user presses Enter
		long end = System.currentTimeMillis();

		typingFinished.set(true); // stop the countdown
		countdownThread.interrupt(); // in case it’s sleeping
		System.out.println(); // move to next line after countdown

		boolean correct = input.equals(sentence);
		long timeTaken = end - start;
		boolean fastEnough = timeTaken < seconds * 1000;

		boolean won = fastEnough && correct;

		if (won)
			PrintHelper.printDialog("Correct! Time taken: " + timeTaken + " ms");
		else
			PrintHelper.printDialog(!correct ? "Wrong sentence typed" : "Too slow");

		return won;
	}

}

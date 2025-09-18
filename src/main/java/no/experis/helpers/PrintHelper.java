package main.java.no.experis.helpers;

import main.java.no.experis.config.GameConfig;

public class PrintHelper {

	// Prints a title with framing and dramatic timing
	public static void printTitle(String title) {
		title = title.toUpperCase();
		int width = 60; // target "screen width"
		String border = repeat("=", width);

		System.out.println("\n\n" + border);

		// Center the title
		int padding = (width - title.length()) / 2;
		String line = repeat(" ", padding) + title;

		// Print with slower, dramatic effect
		print(line, GameConfig.get().titleSpeed);

		System.out.println(border + "\n");
	}

	public static void printDialog(String dialog) {
		print(dialog, GameConfig.get().dialogSpeed);
	}

	public static void printFast(String text) {
		print(text, GameConfig.get().fastPrintSpeed);
	}

	// Prints text with a typewriter effect
	private static void print(String text, long delay) {
		for (char character : text.toCharArray()) {
			System.out.print(character);
			System.out.flush(); // make sure it shows immediately
			try {
				if (character != ' ')
					Thread.sleep(delay);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(); // move to next line after finishing
	}

	private static String repeat(String s, int count) {
		return s.repeat(Math.max(0, count));
	}
}

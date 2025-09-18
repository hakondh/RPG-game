package main.java.no.experis.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Singleton
// - Private constructor
// - Static instance field
// - Static loader/accessor
public class GameConfig {
	public final long dialogSpeed;
	public final long titleSpeed;
	public final long fastPrintSpeed;

	private static GameConfig instance;

	private GameConfig() throws IOException {
		Properties props = new Properties();
		try (InputStream in = GameConfig.class.getResourceAsStream("game.config")) {
			if (in == null) {
				throw new IOException("Could not find game.config");
			}

			props.load(in);
		}

		this.dialogSpeed = Long.parseLong(props.getProperty("dialogSpeed"));
		this.titleSpeed = Long.parseLong(props.getProperty("titleSpeed"));
		this.fastPrintSpeed = Long.parseLong(props.getProperty("fastPrintSpeed"));
	}

	public static GameConfig load() throws IOException {
		if (instance == null) {
			instance = new GameConfig();
		}

		return instance;
	}

	public static GameConfig get() {
		if (instance == null)
			throw new IllegalStateException("Config not loaded");

		return instance;
	}
}

package main.java.no.experis.factories;

import main.java.no.experis.constants.MageConstants;
import main.java.no.experis.constants.RangerConstants;
import main.java.no.experis.hero.strategies.LevelUpMage;
import main.java.no.experis.hero.strategies.LevelUpRanger;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;

public class WeaponFactory {
	public Weapon getWeapon(String name, WeaponClass WeaponClass, int level) {
		switch (WeaponClass) {
		case MELEE -> {
			return new Weapon(name, WeaponClass, level);
		}
		case RANGED -> {
			WeaponStats = new WeaponStats(RangerConstants.START_HP, RangerConstants.START_STR,
					RangerConstants.START_DEX, RangerConstants.START_INT);
			levelUpStrategy = new LevelUpRanger();
			return new Weapon(name, WeaponClass, WeaponStats, WeaponSlots, levelUpStrategy);
		}
		case MAGIC -> {
			WeaponStats = new WeaponStats(MageConstants.START_HP, MageConstants.START_STR, MageConstants.START_DEX,
					MageConstants.START_INT);
			levelUpStrategy = new LevelUpMage();
			return new Weapon(name, WeaponClass, WeaponStats, WeaponSlots, levelUpStrategy);
		}
		}
		return null;
	}
}

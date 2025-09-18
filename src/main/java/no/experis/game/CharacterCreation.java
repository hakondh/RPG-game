package main.java.no.experis.game;

import java.util.Scanner;

import main.java.no.experis.factories.FactoryRegistry;
import main.java.no.experis.helpers.PrintHelper;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.items.armor.Armor;
import main.java.no.experis.items.armor.ArmorBodyPart;
import main.java.no.experis.items.armor.ArmorClass;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;

public class CharacterCreation {
	private Scanner scanner = new Scanner(System.in);

	public Actor execute() {
		PrintHelper.printTitle("Enter your hero's name: ");
		String name = scanner.nextLine();

		ActorClass actorClass = chooseClass();

		var factoryRegistry = FactoryRegistry.getInstance();
		var factory = factoryRegistry.getFactory(actorClass);
		var hero = factory.createActor(name);

		PrintHelper.printTitle("It's dangerous to go alone. Take this.");

		equipBasics(hero);

		hero.displayStats();

		return hero;
	}

	private ActorClass chooseClass() {
		PrintHelper.printTitle("Choose a class: ");
		for (ActorClass hc : ActorClass.values()) {
			PrintHelper.printDialog("~~~ " + hc + " ~~~");
		}
		while (true) {
			String input = scanner.nextLine().toUpperCase();
			try {
				return ActorClass.valueOf(input);
			} catch (IllegalArgumentException e) {
				PrintHelper.printDialog("Invalid class. Try again.");
			}
		}
	}

	private void equipBasics(Actor hero) {
		Weapon weapon = null;
		Armor armor = null;

		switch (hero.getActorClass()) {
		case MAGE:
			weapon = new Weapon("Club", WeaponClass.MELEE, 10);
			armor = new Armor("Bronze Breast Plate", ArmorBodyPart.BODY, ArmorClass.PLATE, 10);
		case RANGER:
			weapon = new Weapon("Slingshot", WeaponClass.RANGED, 10);
			armor = new Armor("Leather Shirt", ArmorBodyPart.BODY, ArmorClass.LEATHER, 10);
		case WARRIOR:
			weapon = new Weapon("Magical stick", WeaponClass.RANGED, 10);
			armor = new Armor("Cloth Shirt", ArmorBodyPart.BODY, ArmorClass.CLOTH, 10);

			hero.equip(weapon).apply();
			hero.equip(armor).apply();
		}

		hero.giveXp(100).apply();
	}
}

package main.java.no.experis.game;

import main.java.no.experis.factories.FactoryRegistry;
import main.java.no.experis.factories.IActorFactory;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.items.armor.Armor;
import main.java.no.experis.items.armor.ArmorBodyPart;
import main.java.no.experis.items.armor.ArmorClass;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;

public class RolePlayingGameSimulation {
	public void execute() {
		/*
		 * The following code demonstrates the functionality of the RPG system. The
		 * HeroClass, level, equipment and so on for Fingolfin is equal to the example
		 * given in the assignment description. That way, we see if the program returns
		 * expected output values.
		 */

		FactoryRegistry registry = FactoryRegistry.getInstance();

		IActorFactory warriorFactory = registry.getFactory(ActorClass.WARRIOR);
		IActorFactory rangerFactory = registry.getFactory(ActorClass.RANGER);
		IActorFactory mageFactory = registry.getFactory(ActorClass.MAGE);

		// Generate some characters and demonstrate the level up give giving them xp
		Actor fingolfin = warriorFactory.createActor("Fingolfin");
		fingolfin.giveXp(210).apply();
		fingolfin.displayStats();
		fingolfin.giveXp(1139).apply(); // Will get a level 9 Warrior, like in the example
		fingolfin.displayStats();

		/*
		 * Create some items; demonstrate the creation of a melee weapon, ranged weapon,
		 * a magic weapon a helmet, body, and legs. The armor can be a mixture of cloth,
		 * leather, and plate
		 */
		Weapon ringil = new Weapon("Ringil", WeaponClass.MELEE, 5);
		Armor silverBreastPlate = new Armor("Silver Breast Plate", ArmorBodyPart.BODY, ArmorClass.PLATE, 5);

		// Equipment of the same type/level as the example
		fingolfin.equip(ringil).apply();
		fingolfin.equip(silverBreastPlate).apply();

		fingolfin.displayStats(); // Will give the same stats as the example

		// Change equipment of characters
		Armor clothShirt = new Armor("Cloth Shirt", ArmorBodyPart.BODY, ArmorClass.CLOTH, 10);
		fingolfin.equip(clothShirt).apply();
		;
		fingolfin.displayStats();

		// Showcase the characters attacking
		fingolfin.attack();

		/*
		 * The following code creates som different types of Heroes, with some different
		 * types of equipment
		 */

		// RANGER
		Actor fingon = rangerFactory.createActor("Fingon");
		fingon.displayStats();
		fingon.giveXp(500).apply();
		// Give the ranger a combination of different armor types
		Weapon fingonsBow = new Weapon("Fingon's Bow", WeaponClass.RANGED, 15);
		Armor goldenHelmet = new Armor("Golden Helmet", ArmorBodyPart.HEAD, ArmorClass.PLATE, 5);
		Armor leatherShirt = new Armor("Leather Shirt", ArmorBodyPart.BODY, ArmorClass.LEATHER, 10);
		Armor clothLeggings = new Armor("Cloth Leggings", ArmorBodyPart.LEGS, ArmorClass.CLOTH, 15);
		fingon.equip(fingonsBow).apply();
		fingon.equip(goldenHelmet).apply();
		fingon.equip(leatherShirt).apply();
		fingon.equip(clothLeggings).apply();
		fingon.displayStats();

		// MAGE
		Actor morgoth = mageFactory.createActor("Morgoth");
		Weapon grond = new Weapon("Grond", WeaponClass.MAGIC, 20);
		morgoth.displayStats();
		morgoth.equip(grond).apply();
		morgoth.displayStats();
		morgoth.attack();
		morgoth.giveXp(3000).apply();
		// As Morgoth has leveled up, he should deal more damage now
		morgoth.attack();

		// Display stats for some of the created items
		ringil.displayStats();
		silverBreastPlate.displayStats();
		clothShirt.displayStats();
		leatherShirt.displayStats();
		fingonsBow.displayStats();
		grond.displayStats();
	}
}

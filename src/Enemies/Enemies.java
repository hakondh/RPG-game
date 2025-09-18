package Enemies;

import java.util.ArrayList;
import java.util.List;

import main.java.no.experis.factories.FactoryRegistry;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.items.armor.Armor;
import main.java.no.experis.items.armor.ArmorBodyPart;
import main.java.no.experis.items.armor.ArmorClass;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;

public class Enemies {
	public List<Actor> GetEnemies() {
		ArrayList<Actor> enemies = new ArrayList<>();

		var factoryRegistry = FactoryRegistry.getInstance();
		var mageFactory = factoryRegistry.getFactory(ActorClass.MAGE);
		var rangerFactory = factoryRegistry.getFactory(ActorClass.RANGER);

		Actor celegorm = rangerFactory.createActor("Celegorm");
		Weapon celegormsBow = new Weapon("Celegorm's Bow", WeaponClass.RANGED, 15);
		Armor goldenHelmet = new Armor("Golden Helmet", ArmorBodyPart.HEAD, ArmorClass.PLATE, 5);
		Armor leatherShirt = new Armor("Leather Shirt", ArmorBodyPart.BODY, ArmorClass.LEATHER, 10);
		Armor clothLeggings = new Armor("Cloth Leggings", ArmorBodyPart.LEGS, ArmorClass.CLOTH, 15);
		celegorm.giveXp(140).noDialog().apply();
		celegorm.equip(celegormsBow).noDialog().apply();
		celegorm.equip(goldenHelmet).noDialog().apply();
		celegorm.equip(leatherShirt).noDialog().apply();
		celegorm.equip(clothLeggings).noDialog().apply();

		Actor sauron = mageFactory.createActor("Sauron");
		Weapon mace = new Weapon("Heavy Mace", WeaponClass.MELEE, 5);
		Armor blackBreastPlate = new Armor("Black Breast Plate", ArmorBodyPart.BODY, ArmorClass.PLATE, 5);
		sauron.giveXp(120).noDialog().apply(); // Will get a level 9 Mage
		sauron.equip(mace).noDialog().apply();
		sauron.equip(blackBreastPlate).noDialog().apply();

		enemies.add(celegorm);
		enemies.add(sauron);

		return enemies;
	}
}

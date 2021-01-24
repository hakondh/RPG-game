package main.java.no.experis.game;

import main.java.no.experis.Hero;
import main.java.no.experis.factories.HeroFactory;
import main.java.no.experis.HeroClass;
import main.java.no.experis.items.armor.Armor;
import main.java.no.experis.items.armor.ArmorClass;
import main.java.no.experis.items.armor.strategies.ArmorBodyPart;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;

public class RolePlayingGame {
    public void run() {
        /*
            The following code demonstrates the functionality of the RPG system.
            The HeroClass, level, equipment and so on for Fingolfin is equal to the
            example given in the assignment description. That way, we see if the
            program returns expected output values.
         */
        HeroFactory heroFactory = new HeroFactory();

        // Generate some characters and demonstrate the level up give giving them xp
        Hero fingolfin = heroFactory.getHero("Fingolfin", HeroClass.WARRIOR);
        fingolfin.displayHeroStats();
        fingolfin.giveXP(1139); // Will get a level 9 Warrior, like in the example
        fingolfin.displayHeroStats();

        /* Create some items; demonstrate the creation of a melee weapon, ranged weapon, a magic weapon
        a helmet, body, and legs. The armor can be a mixture of cloth, leather, and plate */
        Weapon ringil = new Weapon("Ringil", WeaponClass.MELEE, 5);
        Armor silverBreastPlate = new Armor("Silver Breast Plate", ArmorBodyPart.BODY, ArmorClass.PLATE, 5);

        // Equipment of the same type/level as the example
        fingolfin.equip(ringil);
        fingolfin.equip(silverBreastPlate);

        fingolfin.displayHeroStats(); // Will give the same stats as the example

        // Change equipment of characters
        Armor clothShirt = new Armor("Cloth Shirt", ArmorBodyPart.BODY, ArmorClass.CLOTH, 10);
        fingolfin.equip(clothShirt);
        fingolfin.displayHeroStats();

        // Showcase the characters attacking
        fingolfin.attack();

        /* The following code creates som different types of Heroes, with some different types of equipment */

        // RANGER
        Hero fingon = heroFactory.getHero("Fingon", HeroClass.RANGER);
        fingon.displayHeroStats();
        fingon.giveXP(500);
        // Give the ranger a combination of different armor types
        Weapon fingonsBow = new Weapon("Fingon's Bow", WeaponClass.RANGED, 15);
        Armor goldenHelmet = new Armor("Golden Helmet", ArmorBodyPart.HEAD, ArmorClass.PLATE, 5);
        Armor leatherShirt = new Armor("Leather Shirt", ArmorBodyPart.BODY, ArmorClass.LEATHER, 10);
        Armor clothLeggings = new Armor("Cloth Leggings", ArmorBodyPart.LEGS, ArmorClass.CLOTH, 15);
        fingon.equip(fingonsBow);
        fingon.equip(goldenHelmet);
        fingon.equip(leatherShirt);
        fingon.equip(clothLeggings);
        fingon.displayHeroStats();

        // MAGE
        Hero morgoth = heroFactory.getHero("Morgoth", HeroClass.MAGE);
        morgoth.displayHeroStats();
    }
}

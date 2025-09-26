# RPG Characters

## About

A RPG character system written in Java. The program lets you create characters (reffered to as "heroes"), weapons and armor. 
The heroes has a class, either *warrior*, *ranger* or *mage*. All heroes have the attributes *health*, *strength*, *dexterity* and *intelligence*, but the starting values for these attributes are depend on what class the hero has. 

The heroes can gain xp, and if they get enough of it, they will level up. Leveling up will add to the values of the attributes, making them stronger. However, how and what attributes that are affected will, again, depend on what class the hero has. 

Heroes can equip both weapons and armor. 

Equipping a weapon will increase their attack damage. There are different type of weapons: *melee*, *ranged* and *magic*. Attributes of the hero can increase the attack damage, but it has to match the weapon type to have any effect. For example, *strength* will increase damage for *melee* weapons, while *dexterity* will increase damage for *ranged* weapons. 

Equipping armor will affect a heros's attributes. There are different types of armor: *cloth*, *leather* and *plate*. This types will add to the attributes in different ways. For example, *cloth* will add more to *intelligence* and less to *health*, while *plate* will add more to *health* and nothing to *intelligence*. In addition to this, a piece of armor can either be for the hero's *head*, *body* or *legs*. How much is added to the attributes of the hero will depend on where the armor piece fits. For example, body will scale 100 %, while legs scale 60 %. 

The hero can change equipment by simply equipping another item. The attributes of the hero is then changes accordingly.

The hero can attack, and doing so will show how much damage is dealt. It is also possible to display stats for heroes, weapons and armor.

Information about a hero will look something like this:

    WARRIOR Fingolfin details: 
    HP: 480 (+90)
    STR: 63 (+13)
    DEX: 25 (+6)
    INT: 9 (+0)
    LVL: 9
    XP to next: 212
    Attacking for 119

The first number after the attribute is the total value, while the value in parenthesis is the bonus value. 

## How to run

The program can be run by simply opening it in an IDE, and using the IDE's tools to run the main method, which can be found in *src/main/java/no/experis/game/Main.java*. 

## Code design/structure

This project demonstrates the use of SOLID principles, and includes some design patterns as well. The code is also ment to be as extendable as possible. In other words, it should be as easy as possible to add new characters, weapons, armor, abilities, and so on. 

The code is divided into five sub packages under *src/main/java/no/expers*: *constants*, *factories*, *game*, *hero* and *items*.

**1. Constants** <br />
This package contains many of the constants that is used throghout the RPG system. They are put in their own files, so that you can tweak certain values easily, without having to find them in the code and change every occurance. 

**2. Factories:** <br />
This package contains the factory classes. This package only contains one class for the time being, the *HeroFactory*, which makes creating a new hero an easy task. It simply takes the name and the class of the new hero, and sets the default values accordingly.

**3. Game:** <br />
This package contains the code to run the game itself. The entry point can be found in the file *Main*. It also contains the file *RolePLayingGame*, which creates all the heroes and items, and performs some interactions on them. 

**4. Hero:** <br />
This package contains everything related to the heroes. *Hero* represents the hero, and offers methods to perform actions that the hero can do, like leveling up, equipping items, attack and display stats. All other files found in this package is part of *Hero* in some form. 
- *HeroStats* represents all the attributes of the hero, as well as the "bonus values" it gets through putting on armor. The bonues values are added to, not set directly, as there can be many armour pieces that together decides what the total bonus value will be. 
- *HeroSlots* represents the "inventory" of the hero, and is where the items a hero equips is stored. 
- *HeroClass* is an enumerator, which contains all the classes a hero can be. 
You also have the sub package *strategies*. This package contains the logic for leveling up the hero, which is slightly different for each class.

**5. Items:** <br />
This package contains everything related to items. 
- The *Equipable* interface contains all the methods that an *Equipable* should implement. Both weapon and armor implements Equipable. That way, the hero can equip, get the name and get info about the item, without knowing if it is a weapon or a piece of armor. 
- The sub package *strategies* contains *EquipStrategy*. Both weapon and armor have their special logic for getting equipped, found in *EquipWeapon* and *EquipArmor* in the same package, both implementing *EquipStrategy*. 
- The sub package *weapon* contains everything related to weapons. *Weapon* contains all the methods to get information about the weapon, like name, base damage, bonus damage, and so on. Each *Weapon* also has a *WeaponStrategy*, as there are different types of weapons, that will differ in how damage is calculated. What *WeaponStrategy* the *Weapon* should use is decided from the enumerator *WeaponClass* that is passed in from the client. You get the *WeaponStrategy* from the enum itself. 
- The sub package *armor* contains everything related to armor. *Armor* contains all the methods to get information about the armor piece, like name, what body type it fits into, the bonuses, and so on. Each armor also has a *ArmorStrategy*, as there are different types of armor, that will differ in how bonuses are calculated. What *ArmorStrategy* the *Armor* should use is decided from the enumerator *ArmorClass* that is passed in from the client. You get the *ArmorStrategy* from the enum itself. The calculated bonuses will *also* depend on the scaling, which is different for each body part. The scaling for the armor is set using the enumerator *ArmorBodyPart*.

**Class diagram for the Hero structure**

<img width="12246" height="5442" alt="RPG Game Class Diagram (4)" src="https://github.com/user-attachments/assets/d1088682-1ff0-4420-9ac3-e5270298b588" />




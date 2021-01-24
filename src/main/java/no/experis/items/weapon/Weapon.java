package main.java.no.experis.items.weapon;

import main.java.no.experis.HeroSlots;
import main.java.no.experis.HeroStats;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.weapon.strategies.WeaponStrategy;

public class Weapon implements Equipable {
    private final String name;
    private final WeaponClass weaponClass;
    private final int level;
    private final WeaponStrategy weaponStrategy;

    public Weapon(String name, WeaponClass weaponClass, int level) {
        this.name = name;
        this.weaponClass = weaponClass;
        this.level = level;
        this.weaponStrategy = weaponClass.getWeaponStrategy(); // Set WeaponStrategy based on enum WeaponClass
    }

    // This method places the weapon in a slot of HeroSlots, and updates the stats in HeroStats
    public void place(HeroSlots heroSlots, HeroStats heroStats) {
        heroSlots.setWeapon(this);
        setDamage(heroStats);
    }

    /* Set the damage of the weapon. This method is public so that we can refresh the
    damage of the weapon from the outside when new armor is equipped */
    public void setDamage(HeroStats heroStats) {
        heroStats.setDamage(this.getBaseDamage() + this.getBonusDamage(heroStats));
    }

    // Get the base damage, which will depend on both the type and the level of the weapon
    public int getBaseDamage() {
        return weaponStrategy.getBaseDamage(level);
    }

    // Get the bonus damage, that will depend on both the type of weapon and the stats of the Hero
    private int getBonusDamage(HeroStats heroStats) {
        return weaponStrategy.getBonusDamage(heroStats);
    }
}

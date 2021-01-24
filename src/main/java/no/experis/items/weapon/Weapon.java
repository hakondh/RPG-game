package main.java.no.experis.items.weapon;

import main.java.no.experis.hero.HeroSlots;
import main.java.no.experis.hero.HeroStats;
import main.java.no.experis.items.EquipStrategy;
import main.java.no.experis.items.EquipWeapon;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.weapon.strategies.WeaponStrategy;

public class Weapon implements Equipable {
    private final String name;
    private final WeaponClass weaponClass;
    private final int level;
    private final WeaponStrategy weaponStrategy;
    private final EquipStrategy equipStrategy = new EquipWeapon();

    public Weapon(String name, WeaponClass weaponClass, int level) {
        this.name = name;
        this.weaponClass = weaponClass;
        this.level = level;
        this.weaponStrategy = weaponClass.getWeaponStrategy(); // Set WeaponStrategy based on enum WeaponClass
    }

    public String getName() {
        return name;
    }

    public EquipStrategy getEquipStrategy() {
        return equipStrategy;
    }

    // Get the base damage, which will depend on both the type and the level of the weapon
    public int getBaseDamage() {
        return weaponStrategy.getBaseDamage(level);
    }

    // Get the bonus damage, that will depend on both the type of weapon and the stats of the Hero
    public int getBonusDamage(HeroStats heroStats) {
        return weaponStrategy.getBonusDamage(heroStats);
    }

    public void displayStats() {
        StringBuilder str = new StringBuilder();
        str
                .append("\n").append("Item stats for: ").append(name)
                .append("\nWeapon type: ").append(weaponClass)
                .append("\nWeapon level: ").append(level)
                .append("\nDamage: ").append(getBaseDamage());
        System.out.println(str);
    }
}

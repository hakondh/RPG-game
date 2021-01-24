package main.java.no.experis.items.weapon;

import main.java.no.experis.items.weapon.strategies.Magic;
import main.java.no.experis.items.weapon.strategies.Melee;
import main.java.no.experis.items.weapon.strategies.Ranged;
import main.java.no.experis.items.weapon.strategies.WeaponStrategy;

public enum WeaponClass {
    MELEE(new Melee()),
    RANGED(new Ranged()),
    MAGIC(new Magic());

    private final WeaponStrategy weaponStrategy;
    WeaponClass(WeaponStrategy weaponStrategy) {
        this.weaponStrategy = weaponStrategy;
    }

    // Get the WeaponStrategy that belongs to the WeaponClass
    public WeaponStrategy getWeaponStrategy() {
        return weaponStrategy;
    }
}

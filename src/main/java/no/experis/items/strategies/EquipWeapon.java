package main.java.no.experis.items.strategies;

import main.java.no.experis.hero.HeroSlots;
import main.java.no.experis.hero.HeroStats;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.strategies.EquipStrategy;
import main.java.no.experis.items.weapon.Weapon;

public class EquipWeapon implements EquipStrategy {

    public void equip(Equipable item, HeroSlots heroSlots, HeroStats heroStats) {
        Weapon weapon = (Weapon) item;
        heroSlots.setWeapon(weapon);
    }
}

package main.java.no.experis.items;

import main.java.no.experis.hero.HeroSlots;
import main.java.no.experis.hero.HeroStats;

public interface EquipStrategy {
    void equip(Equipable item, HeroSlots heroSlots, HeroStats heroStats);
}

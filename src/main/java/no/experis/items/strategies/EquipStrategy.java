package main.java.no.experis.items.strategies;

import main.java.no.experis.hero.HeroSlots;
import main.java.no.experis.hero.HeroStats;
import main.java.no.experis.items.Equipable;

// Strategy for how the item is equipped, which will differ depending on if it is weapon or armor
public interface EquipStrategy {
    void equip(Equipable item, HeroSlots heroSlots, HeroStats heroStats);
}

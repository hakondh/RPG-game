package main.java.no.experis.items;

import main.java.no.experis.hero.HeroSlots;
import main.java.no.experis.hero.HeroStats;

public interface Equipable {
    //void place(HeroSlots heroSlots, HeroStats heroStats);
    EquipStrategy getEquipStrategy();
    String getName();
    void displayStats();
}

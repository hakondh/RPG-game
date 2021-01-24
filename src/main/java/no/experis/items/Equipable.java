package main.java.no.experis.items;

import main.java.no.experis.HeroSlots;
import main.java.no.experis.HeroStats;

public interface Equipable {
    void place(HeroSlots heroSlots, HeroStats heroStats);
}

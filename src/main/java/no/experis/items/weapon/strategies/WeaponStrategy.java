package main.java.no.experis.items.weapon.strategies;

import main.java.no.experis.hero.HeroStats;

public interface WeaponStrategy {
    int getBaseDamage(int level);
    int getBonusDamage(HeroStats heroStats);
}

package main.java.no.experis.items.weapon.strategies;

import main.java.no.experis.HeroStats;
import main.java.no.experis.constants.WeaponConstants;

public class Melee implements WeaponStrategy{

    public int getBaseDamage(int level) {
        return WeaponConstants.MELEE_BASE_DMG + (2 * level);
    }

    public int getBonusDamage(HeroStats heroStats) {
        return (int) ((heroStats.getStrength() + heroStats.getBonusStrength())*1.5);
    }
}

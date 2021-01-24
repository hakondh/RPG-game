package main.java.no.experis.items.weapon.strategies;

import main.java.no.experis.HeroStats;
import main.java.no.experis.constants.WeaponConstants;

public class Ranged implements WeaponStrategy{
    public int getBaseDamage(int level) {
        return WeaponConstants.RANGED_BASE_DMG + (3 * level);
    }

    public int getBonusDamage(HeroStats heroStats) {
        return (heroStats.getDexterity() + heroStats.getBonusDexterity())*2;
    }
}

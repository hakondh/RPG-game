package main.java.no.experis.items.weapon.strategies;

import main.java.no.experis.HeroStats;
import main.java.no.experis.constants.WeaponConstants;

public class Magic implements WeaponStrategy{

    public int getBaseDamage(int level) {
        return WeaponConstants.MAGIC_BASE_DMG + (2 * level);
    }

    public int getBonusDamage(HeroStats heroStats) {
        return (heroStats.getIntelligence() + heroStats.getBonusIntelligence())*3;
    }
}

package main.java.no.experis.items.armor.strategies;

import main.java.no.experis.constants.ArmorConstants;

public class Leather implements ArmorStrategy{
    public int getHealth(int level, double scale) {
        return (int)((ArmorConstants.LEATHER_HP_BASE + ArmorConstants.LEATHER_HP_BONUS*level)*scale);
    }

    public int getStrength(int level, double scale) {
        return (int)((ArmorConstants.LEATHER_STR_BASE + ArmorConstants.LEATHER_STR_BONUS*level)*scale);
    }

    public int getDexterity(int level, double scale) {
        return (int)((ArmorConstants.LEATHER_DEX_BASE + ArmorConstants.LEATHER_DEX_BONUS*level)*scale);
    }

    public int getIntelligence(int level, double scale) {
        return (int)((ArmorConstants.LEATHER_INT_BASE + ArmorConstants.LEATHER_INT_BONUS*level)*scale);
    }
}

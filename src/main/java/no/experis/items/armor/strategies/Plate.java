package main.java.no.experis.items.armor.strategies;

import main.java.no.experis.constants.ArmorConstants;

public class Plate implements ArmorStrategy{
    public int getHealth(int level, double scale) {
        return (int)((ArmorConstants.PLATE_HP_BASE + ArmorConstants.PLATE_HP_BONUS*level)*scale);
    }

    public int getStrength(int level, double scale) {
        return (int)((ArmorConstants.PLATE_STR_BASE + ArmorConstants.PLATE_STR_BONUS*level)*scale);
    }

    public int getDexterity(int level, double scale) {
        return (int)((ArmorConstants.PLATE_DEX_BASE + ArmorConstants.PLATE_DEX_BONUS*level)*scale);
    }

    public int getIntelligence(int level, double scale) {
        return (int)((ArmorConstants.PLATE_INT_BASE + ArmorConstants.PLATE_INT_BONUS*level)*scale);
    }
}

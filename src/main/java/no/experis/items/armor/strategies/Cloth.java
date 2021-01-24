package main.java.no.experis.items.armor.strategies;

import main.java.no.experis.constants.ArmorConstants;

public class Cloth implements ArmorStrategy{
    public int getHealth(int level, double scale) {
        return (int)((ArmorConstants.CLOTH_HP_BASE + ArmorConstants.CLOTH_HP_BONUS*level)*scale);
    }

    public int getStrength(int level, double scale) {
        return (int)((ArmorConstants.CLOTH_STR_BASE + ArmorConstants.CLOTH_STR_BONUS*level)*scale);
    }

    public int getDexterity(int level, double scale) {
        return (int)((ArmorConstants.CLOTH_DEX_BASE + ArmorConstants.CLOTH_DEX_BONUS*level)*scale);
    }

    public int getIntelligence(int level, double scale) {
        return (int)((ArmorConstants.CLOTH_INT_BASE + ArmorConstants.CLOTH_INT_BONUS*level)*scale);
    }

}

package main.java.no.experis.items.armor;

import main.java.no.experis.constants.ArmorConstants;
import main.java.no.experis.items.armor.strategies.ArmorStrategy;
import main.java.no.experis.items.armor.strategies.Cloth;
import main.java.no.experis.items.armor.strategies.Leather;
import main.java.no.experis.items.armor.strategies.Plate;

public enum ArmorClass  {
    CLOTH(new Cloth()),
    LEATHER(new Leather()),
    PLATE(new Plate());

    private final ArmorStrategy armorStrategy;
    ArmorClass(ArmorStrategy armorStrategy) {
        this.armorStrategy = armorStrategy;
    }

    public ArmorStrategy getArmorStrategy() {
        return armorStrategy;
    }
}

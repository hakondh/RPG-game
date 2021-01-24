package main.java.no.experis.items.armor.strategies;

import main.java.no.experis.constants.ArmorConstants;

public enum ArmorBodyPart {
    HEAD(ArmorConstants.HEAD_SCALE),
    BODY(ArmorConstants.BODY_SCALE),
    LEGS(ArmorConstants.LEGS_SCALE);

    private final double scale;
    ArmorBodyPart(double scale) {
        this.scale = scale;
    }

    public double getScale() {
        return scale;
    }
}

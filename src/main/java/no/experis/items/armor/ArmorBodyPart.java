package main.java.no.experis.items.armor;

import main.java.no.experis.constants.ArmorConstants;

public enum ArmorBodyPart {
    HEAD(ArmorConstants.HEAD_SCALE),
    BODY(ArmorConstants.BODY_SCALE),
    LEGS(ArmorConstants.LEGS_SCALE);

    private final double scale;
    ArmorBodyPart(double scale) {
        this.scale = scale;
    }

    // Get the scale for armor body part
    public double getScale() {
        return scale;
    }
}

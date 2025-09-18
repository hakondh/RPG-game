package main.java.no.experis.items.armor;

import main.java.no.experis.helpers.PrintHelper;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.armor.strategies.ArmorStrategy;
import main.java.no.experis.items.strategies.EquipArmor;
import main.java.no.experis.items.strategies.EquipStrategy;

public class Armor implements Equipable {
	private final String name;
	private final ArmorBodyPart armorBodyPart;
	private final ArmorClass armorClass;
	private final int level;
	private final ArmorStrategy armorStrategy;
	private final double scale;
	private final EquipStrategy equipStrategy = new EquipArmor();

	public Armor(String name, ArmorBodyPart armorBodyPart, ArmorClass armorClass, int level) {
		this.name = name;
		this.armorBodyPart = armorBodyPart;
		this.armorClass = armorClass;
		this.level = level;
		this.armorStrategy = armorClass.getArmorStrategy(); // Set ArmorStrategy based on enum ArmorStrategy
		this.scale = armorBodyPart.getScale(); // Set scale based on enum ArmorBodyPart
	}

	public String getName() {
		return name;
	}

	public ArmorBodyPart getArmorBodyPart() {
		return armorBodyPart;
	}

	public EquipStrategy getEquipStrategy() {
		return equipStrategy;
	}

	public int getHealthBonus() {
		return armorStrategy.getHealth(level, scale);
	}

	public int getStrengthBonus() {
		return armorStrategy.getStrength(level, scale);
	}

	public int getDexterityBonus() {
		return armorStrategy.getDexterity(level, scale);
	}

	public int getIntelligenceBonus() {
		return armorStrategy.getIntelligence(level, scale);
	}

	// Get information about the armor piece and build a string to display
	public void displayStats() {
		StringBuilder str = new StringBuilder();
		str.append("\n").append("Item stats for: ").append(name).append("\nArmor type: ").append(armorClass)
				.append("\nSlot: ").append(armorBodyPart).append("\nArmor level: ").append(level).append("\nBonus HP: ")
				.append(getHealthBonus()).append("\nBonus Str: ").append(getStrengthBonus()).append("\nBonus Dex: ")
				.append(getDexterityBonus()).append("\nBonus Int: ").append(getIntelligenceBonus());
		PrintHelper.printDialog(str.toString());
	}
}

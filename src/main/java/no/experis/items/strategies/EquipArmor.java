package main.java.no.experis.items.strategies;

import main.java.no.experis.hero.ActorSlots;
import main.java.no.experis.hero.ActorStats;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.armor.Armor;

public class EquipArmor implements EquipStrategy {

	public void equip(Equipable item, ActorSlots heroSlots, ActorStats heroStats) {
		Armor newArmor = (Armor) item; // Cast Equipable to Armor
		Armor oldArmor = null; // Need to get the old Armor as well, so we can decrease stats before adding new
								// bonuses

		// Check what body part this armor should be set for, and get the armor piece
		// that currently is in that slot
		switch (newArmor.getArmorBodyPart()) {
		case HEAD -> {
			oldArmor = heroSlots.getHead();
			heroSlots.setHead(newArmor);
		}
		case BODY -> {
			oldArmor = heroSlots.getBody();
			heroSlots.setBody(newArmor);
		}
		case LEGS -> {
			oldArmor = heroSlots.getLegs();
			heroSlots.setLegs(newArmor);
		}
		}

		// If a armor was equipped previously, then remove the bonus stats that came
		// from it
		if (oldArmor != null)
			decreaseBonusStats(heroStats, oldArmor);
		// Then, add to the bonus stats that we get from the new Armor
		increaseBonusStats(heroStats, newArmor);
	}

	private void decreaseBonusStats(ActorStats heroStats, Armor oldArmor) {
		heroStats.addBonusHealth(-oldArmor.getHealthBonus());
		heroStats.addBonusStrength(-oldArmor.getStrengthBonus());
		heroStats.addBonusDexterity(-oldArmor.getDexterityBonus());
		heroStats.addBonusIntelligence(-oldArmor.getIntelligenceBonus());
	}

	private void increaseBonusStats(ActorStats heroStats, Armor newArmor) {
		heroStats.addBonusHealth(newArmor.getHealthBonus());
		heroStats.addBonusStrength(newArmor.getStrengthBonus());
		heroStats.addBonusDexterity(newArmor.getDexterityBonus());
		heroStats.addBonusIntelligence(newArmor.getIntelligenceBonus());
	}

}

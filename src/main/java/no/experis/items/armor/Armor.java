package main.java.no.experis.items.armor;

import main.java.no.experis.HeroSlots;
import main.java.no.experis.HeroStats;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.armor.strategies.ArmorBodyPart;
import main.java.no.experis.items.armor.strategies.ArmorStrategy;
import main.java.no.experis.items.weapon.Weapon;

public class Armor implements Equipable {
    private final String name;
    private final ArmorBodyPart armorBodyPart;
    private final ArmorClass armorClass;
    private final int level;
    private final ArmorStrategy armorStrategy;
    private final double scale;

    public Armor(String name, ArmorBodyPart armorBodyPart, ArmorClass armorClass, int level) {
        this.name = name;
        this.armorBodyPart = armorBodyPart;
        this.armorClass = armorClass;
        this.level = level;
        this.armorStrategy = armorClass.getArmorStrategy(); // Set ArmorStrategy based on enum ArmorStrategy
        this.scale = armorBodyPart.getScale(); // Set scale based on what body part this armor fits into
    }

    // This method places the weapon in a slot of HeroSlots, and sets new stats in HeroStats
    public void place(HeroSlots heroSlots, HeroStats heroStats) {
        Armor oldArmor = null;
        switch(armorBodyPart) {
            case HEAD -> {
                oldArmor = heroSlots.getHead();
                heroSlots.setHead(this);
            }
            case BODY -> {
                oldArmor = heroSlots.getBody();
                heroSlots.setBody(this);
            }
            case LEGS -> {
                oldArmor = heroSlots.getLegs();
                heroSlots.setLegs(this);
            }
        }
        Weapon weapon = heroSlots.getWeapon(); // Get the Hero's equipped weapon (could be null)
        setStats(heroStats, oldArmor, weapon); // Finally, add to the stats for the newly equipped armor
    }

    public void setStats(HeroStats heroStats, Armor oldArmor, Weapon weapon) {
        if(oldArmor != null) decreaseStats(heroStats, oldArmor); // If a armor was equipped previously, then decrease the bonus stats that came from it
        // Add to the bonus stats
        heroStats.addBonusHealth(getHealthStat());
        heroStats.addBonusStrength(getStrengthStat());
        heroStats.addBonusDexterity(getDexterityStat());
        heroStats.addBonusIntelligence(getIntelligenceStat());

        if(weapon != null) weapon.setDamage(heroStats); // If the Hero has a weapon equipped, the damage dealt needs to change according to change of HeroStats
    }

    public void decreaseStats(HeroStats heroStats, Armor oldArmor) {
        heroStats.addBonusHealth(-oldArmor.getHealthStat());
        heroStats.addBonusStrength(-oldArmor.getStrengthStat());
        heroStats.addBonusDexterity(-oldArmor.getDexterityStat());
        heroStats.addBonusIntelligence(-oldArmor.getIntelligenceStat());
    }

    public int getHealthStat() {
        return armorStrategy.getHealth(level, scale);
    }

    public int getStrengthStat() {
        return armorStrategy.getStrength(level, scale);
    }

    public int getDexterityStat() {
        return armorStrategy.getDexterity(level, scale);
    }

    public int getIntelligenceStat() {
        return armorStrategy.getIntelligence(level, scale);
    }
}

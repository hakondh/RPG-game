package main.java.no.experis;

import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.strategies.LevelUpStrategy;


public class Hero {
    private final String name;
    private final HeroClass heroClass;
    private final HeroStats heroStats;
    private final HeroSlots heroSlots = new HeroSlots();
    private final LevelUpStrategy levelUpStrategy;
    private int level = 1;
    private int xpBank = 0;
    private int xpRequirement = 100;

    public Hero(String name, HeroClass heroClass, HeroStats heroStats, LevelUpStrategy levelUpStrategy) {
        this.name = name;
        this.heroClass = heroClass;
        this.heroStats = heroStats;
        this.levelUpStrategy = levelUpStrategy;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() { return level; }

    public HeroSlots getHeroSlots() {return this.heroSlots;}

    public HeroStats getHeroStats() {return this.heroStats;}

    private void levelUp() {
        this.level++;
        this.levelUpStrategy.levelUp(this.heroStats); // Call the strategy method for leveling up, which differ from HeroClass to HeroClass
        System.out.println(name + " is now level " + level);
    }

    public void giveXP(int xp) {
        xpBank += xp;
        boolean canLevelUp = xpBank >= xpRequirement; // Check if there is enough xp in the bank compared to the requirement
        while(canLevelUp) { // The player will level up as long as the xp in the "xpBank" is greater than or equal the requirement
            xpBank -= xpRequirement; // "Cash in" the xp to get next level
            levelUp();
            xpRequirement = (int)(xpRequirement*1.10);// Increase the requirement to level up
            canLevelUp = xpBank >= xpRequirement; // Check if the Hero has enough xp left to level up again
        }
    }

    // Method to equip an item, which will affect both HeroSlots and HeroStats
    public void equip(Equipable item) {
        item.place(heroSlots, heroStats);
    }

    public void displayHeroStats() {
        int totalHealth = heroStats.getHealth() + heroStats.getBonusHealth();
        int totalStrength = heroStats.getStrength() + heroStats.getBonusStrength();
        int totalDexterity = heroStats.getDexterity() + heroStats.getBonusDexterity();
        int totalIntelligence = heroStats.getIntelligence() + heroStats.getBonusIntelligence();
        // Use StringBuilder for efficiency
        StringBuilder str = new StringBuilder();
        str
                .append("\n").append(heroClass).append(" ").append(name).append(" details: ")
                .append("\n").append("HP: ").append(totalHealth).append(" (+").append(heroStats.getBonusHealth()).append(")")
                .append("\n").append("STR: ").append(totalStrength).append(" (+").append(heroStats.getBonusStrength()).append(")")
                .append("\n").append("DEX: ").append(totalDexterity).append(" (+").append(heroStats.getBonusDexterity()).append(")")
                .append("\n").append("INT: ").append(totalIntelligence).append(" (+").append(heroStats.getBonusIntelligence()).append(")")
                .append("\n").append("LVL: ").append(level)
                .append("\n").append("XP to next: ").append(xpRequirement - xpBank)
                .append("\n").append("- Attacking for " + heroStats.getDamage()).append("\n");
        System.out.println(str);
    }

    public void attack() {
        System.out.println("*" + name + " dealt " + heroStats.getDamage() + " damage*");
    }
}

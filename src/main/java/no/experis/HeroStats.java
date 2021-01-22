package main.java.no.experis;

public class HeroStats {
    private int health;
    private int strength;
    private int intelligence;
    private int dexterity;

    public HeroStats(int health, int strength, int dexterity, int intelligence) {
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getHealth() { return health; }

    public int getStrength() { return strength; }

    public int getIntelligence() { return intelligence; }

    public int getDexterity() { return dexterity; }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
}

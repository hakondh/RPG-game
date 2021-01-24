package main.java.no.experis.hero;

public class HeroStats {
    // The "total" stats
    private int health;
    private int strength;
    private int intelligence;
    private int dexterity;
    // The "bonus" stats
    private int bonusHealth;
    private int bonusStrength;
    private int bonusIntelligence;
    private int bonusDexterity;
    // Total damage dealt from weapon
    private int damage = 0;

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

    public int getDamage() { return damage; }

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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public void addBonusHealth(int bonusHealth) {
        this.bonusHealth += bonusHealth;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public void addBonusStrength(int bonusStrength) {
        this.bonusStrength += bonusStrength;
    }

    public int getBonusIntelligence() {
        return bonusIntelligence;
    }

    public void addBonusIntelligence(int bonusIntelligence) {
        this.bonusIntelligence += bonusIntelligence;
    }

    public int getBonusDexterity() {
        return bonusDexterity;
    }

    public void addBonusDexterity(int bonusDexterity) {
        this.bonusDexterity += bonusDexterity;
    }
}

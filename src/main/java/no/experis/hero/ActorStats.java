package main.java.no.experis.hero;

public class ActorStats {
	private int baseHealth;
	// The "total" stats
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

	public ActorStats(int health, int strength, int dexterity, int intelligence) {
		this.baseHealth = health;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
	}

	public int getBaseHealth() {
		return baseHealth;
	}

	public int getTotalHealth() {
		return baseHealth + bonusHealth;
	}

	public int getStrength() {
		return strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getDamage() {
		return damage;
	}

	public void setHealth(int health) {
		this.baseHealth = health;
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

	public int getBonusStrength() {
		return bonusStrength;
	}

	public int getBonusIntelligence() {
		return bonusIntelligence;
	}

	public int getBonusDexterity() {
		return bonusDexterity;
	}

	public void addHealth(int number) {
		this.baseHealth += number;
		if (this.baseHealth < 0)
			this.baseHealth = 0;
	}

	public void addBonusHealth(int bonusHealth) {
		this.bonusHealth += bonusHealth;
	}

	public void addBonusStrength(int bonusStrength) {
		this.bonusStrength += bonusStrength;
	}

	public void addBonusIntelligence(int bonusIntelligence) {
		this.bonusIntelligence += bonusIntelligence;
	}

	public void addBonusDexterity(int bonusDexterity) {
		this.bonusDexterity += bonusDexterity;
	}
}

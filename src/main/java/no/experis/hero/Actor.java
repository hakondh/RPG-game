package main.java.no.experis.hero;

import main.java.no.experis.helpers.PrintHelper;
import main.java.no.experis.hero.strategies.LevelUpStrategy;
import main.java.no.experis.items.Equipable;
import main.java.no.experis.items.weapon.Weapon;

public abstract class Actor {
	private final String name;
	private final ActorClass actorClass;
	private final ActorStats actorStats;
	private final ActorSlots actorSlots = new ActorSlots();
	private final LevelUpStrategy levelUpStrategy;
	private int level = 1;
	private int hp = 0;
	private int xpBank = 0;
	private int xpRequirement = 100;

	public Actor(String name, ActorClass actorClass, ActorStats actorStats, LevelUpStrategy levelUpStrategy) {
		this.name = name;
		this.actorClass = actorClass;
		this.actorStats = actorStats;
		this.levelUpStrategy = levelUpStrategy;
	}

	public String getName() {
		return this.name;
	}

	public ActorClass getActorClass() {
		return this.actorClass;
	}

	public int getLevel() {
		return level;
	}

	public int getHp() {
		return hp;
	}

	public ActorSlots getActorSlots() {
		return this.actorSlots;
	}

	public ActorStats getActorStats() {
		return this.actorStats;
	}

	public XpAction giveXp(int xp) {
		return new XpAction(this, xp);
	}

	// Give the actor xp and see if leveling up is possible
	protected XpResult giveXpToActor(int xp) {
		xpBank += xp;

		// Check if there is enough xp in the bank compared to the requirement
		boolean canLevelUp = xpBank >= xpRequirement;

		var originalLevel = this.level;

		while (canLevelUp) { // The player will level up as long as the xp in the "xpBank" is greater than or
								// equal the requirement
			xpBank -= xpRequirement; // "Cash in" the xp to get next level
			levelUp();
			xpRequirement = (int) (xpRequirement * 1.10);// Increase the requirement to level up
			canLevelUp = xpBank >= xpRequirement; // Check if the actor has enough xp left to level up again
		}

		var levelsGained = this.level - originalLevel;

		return new XpResult(levelsGained);
	}

	private void levelUp() {
		// Call the strategy method for levelling up,
		// which is different for the various Actor classes
		this.levelUpStrategy.levelUp(this.actorStats);

		this.level++;

		/*
		 * The damage of the weapon is affected by leveling up. So, increase damage if
		 * any weapon is equipped. (Another way to do this is to calculate the damage
		 * every time an actor attacks. I chose to rather do it this way, to avoid
		 * having to do that calculation every single time an actor attacks.
		 */
		Weapon weapon = actorSlots.getWeapon();
		if (weapon != null)
			actorStats.setDamage(weapon.getBaseDamage() + weapon.getBonusDamage(actorStats));

		// Set health to max when leveling up
		this.hp = actorStats.getTotalHealth();

	}

	public EquipAction equip(Equipable item) {
		return new EquipAction(this, item);
	}

	// Method to equip an item, which will affect both ActorSlots and ActorStats
	protected void equipItem(Equipable item) {
		/*
		 * The logic for equipping is different for weapon and armor, as armor affects
		 * stats when it's put into a slot, while a weapon only should affect the attack
		 * damage. So, we get the EquipStrategy of the Equipable, which is either
		 * EquipWeapon or EquipArmor. These strategies override method equip()
		 */
		item.getEquipStrategy().equip(item, this.actorSlots, this.actorStats);

		/*
		 * When an item is equipped, it will always affect the damage of the weapon. So,
		 * to avoid having to calculate the weapon attack damage every time we display
		 * the stats or perform an attack, we set the weapon damage again when an item
		 * is equipped. This is also done when the actor levels up (see comment in that
		 * method).
		 */
		Weapon weapon = actorSlots.getWeapon();
		if (weapon != null)
			actorStats.setDamage(weapon.getBaseDamage() + weapon.getBonusDamage(actorStats));
	}

	// Gets the stats for the actor, and builds a string to display
	public void displayStats() {
		int totalHealth = actorStats.getTotalHealth();
		int totalStrength = actorStats.getStrength() + actorStats.getBonusStrength();
		int totalDexterity = actorStats.getDexterity() + actorStats.getBonusDexterity();
		int totalIntelligence = actorStats.getIntelligence() + actorStats.getBonusIntelligence();
		// Use StringBuilder for efficiency
		StringBuilder str = new StringBuilder();
		str.append("\n").append(actorClass).append(" ").append(name).append(" details: ").append("\n").append("HP: ")
				.append(this.hp).append(" / ").append(totalHealth).append(" (+").append(actorStats.getBonusHealth())
				.append(")").append("\n").append("STR: ").append(totalStrength).append(" (+")
				.append(actorStats.getBonusStrength()).append(")").append("\n").append("DEX: ").append(totalDexterity)
				.append(" (+").append(actorStats.getBonusDexterity()).append(")").append("\n").append("INT: ")
				.append(totalIntelligence).append(" (+").append(actorStats.getBonusIntelligence()).append(")")
				.append("\n").append("LVL: ").append(level).append("\n").append("XP to next lvl: ")
				.append(xpRequirement - xpBank).append("\n").append("Attack damage: " + actorStats.getDamage());
		PrintHelper.printDialog(str.toString());
	}

	public void attack() {
		PrintHelper.printDialog("\n*" + name + " dealt " + actorStats.getDamage() + " damage*");
	}

	public void attack(Actor actor) {
		var damage = this.actorStats.getDamage();
		actor.addHP(-damage);
		PrintHelper.printDialog("\n" + name + " struck " + actor.getName() + "!");
		PrintHelper.printDialog("\n" + damage + " damage was dealt");
	}

	public void addHP(int number) {
		this.hp += number;

		if (this.hp < 0)
			this.hp = 0;
	}
}

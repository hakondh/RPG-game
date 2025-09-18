package main.java.no.experis.hero;

import main.java.no.experis.helpers.PrintHelper;
import main.java.no.experis.items.Equipable;

public class EquipAction extends RPGAction {
	private final Actor actor;
	private final Equipable equipable;

	public EquipAction(Actor actor, Equipable equipable) {
		this.actor = actor;
		this.equipable = equipable;
	}

	@Override
	protected void execute() {
		actor.equipItem(equipable); // actual equip logic

		if (showDialog) {
			// Custom message for equipping
			PrintHelper.printDialog("\n*" + actor.getName() + " equipped " + equipable.getName() + "*");
		}
	}
}

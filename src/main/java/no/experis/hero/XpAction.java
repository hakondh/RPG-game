package main.java.no.experis.hero;

import main.java.no.experis.helpers.PrintHelper;

public class XpAction extends RPGAction {
	private final Actor actor;
	private final int xp;

	public XpAction(Actor actor, int xp) {
		this.actor = actor;
		this.xp = xp;
	}

	@Override
	protected void execute() {
		var result = actor.giveXpToActor(xp);

		if (showDialog) {
			// Conditional dialog
			PrintHelper.printDialog("\n*" + actor.getName() + " got " + xp + " XP*");

			if (result.levelsGained > 0) {
				StringBuilder str = new StringBuilder();
				str.append(actor.getName()).append(" leveled up ").append(result.levelsGained);

				if (result.levelsGained > 1)
					str.append(" times ");

				str.append(" and is now level ").append(actor.getLevel()).append("!");

				PrintHelper.printDialog(str.toString());
			}
		}
	}
}

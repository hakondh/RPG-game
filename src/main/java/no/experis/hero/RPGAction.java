package main.java.no.experis.hero;

public abstract class RPGAction {
	protected boolean showDialog = true;

	public RPGAction noDialog() {
		this.showDialog = false;
		return this;
	}

	// Template method
	public final void apply() {
		execute();
	}

	/**
	 * Subclasses implement logic specific to the action. Will print dialog
	 * depending on if noDialog has been used or not.
	 */
	protected abstract void execute();
}
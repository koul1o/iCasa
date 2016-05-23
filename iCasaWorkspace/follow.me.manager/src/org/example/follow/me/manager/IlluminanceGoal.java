package org.example.follow.me.manager;

import fr.liglab.adele.icasa.simulator.Person;

/**
 * This enum describes the different illuminance goals associated with the
 * manager.
 */
public enum IlluminanceGoal {

	/** The goal associated with soft illuminance. */
	SOFT(1, 0.7, true),
	/** The goal associated with medium illuminance. */
	MEDIUM(2, 0.5, false),
	/** The goal associated with full illuminance. */
	FULL(3, 1, false);

	/** The number of lights to turn on. */
	private int numberOfLightsToTurnOn;
	private double persentage;
	private boolean onlyBin;

	private IlluminanceGoal(int numberOfLightsToTurnOn, double persentage, boolean onlyBin) {
		this.numberOfLightsToTurnOn = numberOfLightsToTurnOn;
		this.setPersentage(persentage);
		this.onlyBin = onlyBin;
	}

	/**
	 * Gets the number of lights to turn On.
	 *
	 * @return the number of lights to turn On.
	 */
	public int getNumberOfLightsToTurnOn() {

		return numberOfLightsToTurnOn;
	}

	/**
	 * Instantiates a new illuminance goal.
	 *
	 * @param numberOfLightsToTurnOn
	 *            the number of lights to turn on.
	 */
	private IlluminanceGoal(int numberOfLightsToTurnOn) {
		this.numberOfLightsToTurnOn = numberOfLightsToTurnOn;
	}

	public double getPersentage() {
		return persentage;
	}

	public void setPersentage(double persentage) {
		this.persentage = persentage;
	}

	public boolean isOnlyBin() {
		return onlyBin;
	}

	public void setOnlyBin(boolean onlyBin) {
		this.onlyBin = onlyBin;
	}

	Person myPerson;

}

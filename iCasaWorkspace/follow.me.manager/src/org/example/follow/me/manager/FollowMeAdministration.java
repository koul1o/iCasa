package org.example.follow.me.manager;

/**
 * The Interface FollowMeAdministration allows the administrator to configure
 * its preference regarding the management of the Follow Me application.
 */
public interface FollowMeAdministration {

	/**
	 * Sets the illuminance preference. The manager will try to adjust the
	 * illuminance in accordance with this goal.
	 *
	 * @param goal
	 *            the new illuminance preference
	 */
	public void setIlluminancePreference(IlluminanceGoal illuminanceGoal);

	public IlluminanceGoal getIlluminancePreference();

	public void setEnergyGoal(EnergyGoal energyGoal);

	public EnergyGoal getEnergyGoal();

}
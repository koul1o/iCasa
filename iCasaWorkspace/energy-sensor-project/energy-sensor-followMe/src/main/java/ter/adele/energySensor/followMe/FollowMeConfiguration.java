package ter.adele.energySensor.followMe;

import org.apache.felix.ipojo.annotations.Provides;

/**
 * The FollowMeConfiguration service allows one to configure the Follow Me
 * application.
 */
@Provides
public interface FollowMeConfiguration {
	// public static final int MAX_LIGHTS = 0;

	/**
	 * Gets the maximum number of lights to turn on each time an user is
	 * entering a room.
	 *
	 * @return the maximum number of lights to turn on
	 */
	public int getMaximumNumberOfLightsToTurnOn();

	/**
	 * Sets the maximum number of lights to turn on each time an user is
	 * entering a room.
	 *
	 * @param maximumNumberOfLightsToTurnOn
	 *            the new maximum number of lights to turn on
	 */

	public void setMaximumNumberOfLightsToTurnOn(int maximumNumberOfLightsToTurnOn);

	public double getMaximumAllowedEnergyInRoom();

	/**
	 * Sets the maximum allowed energy consumption in Watts in each room
	 *
	 * @param maximumEnergy
	 *            the maximum allowed energy consumption in Watts/hours in each
	 *            room
	 */
	public void setMaximumAllowedEnergyInRoom(double maximumEnergy);

	public void setOnlyDim(boolean onlyBin);

	public boolean isOnlyDim();

	public void setPersentage(double persentage);

	public double getPersentage();

	public double[] getLightsCombination();

}
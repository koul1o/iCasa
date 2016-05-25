package ter.adele.energySensor.manager;

public enum EnergyGoal {
	LOW(200d), MEDIUM(300d), HIGH(1000d);

	/**
	 * The corresponding maximum energy in watt
	 */
	private double maximumEnergyInRoom;

	/**
	 * get the maximum energy consumption in each room
	 *
	 * @return the energy in watt
	 */
	public double getMaximumEnergyInRoom() {
		return maximumEnergyInRoom;
	}

	private EnergyGoal(double powerInWatt) {
		maximumEnergyInRoom = powerInWatt;
	}
}
package org.example.time;

public enum MomentOfTheDay {
	MORNING(6), AFTERNOON(12), EVENING(18), NIGHT(22);

	/**
	 * Gets the moment of the day corresponding to the hour.
	 *
	 * @param hour
	 *            the given hour
	 * @return the corresponding moment of the day
	 */
	MomentOfTheDay getCorrespondingMoment(int hour) {
		assert ((0 <= startHour) && (startHour <= 24));
		// TODO : if (hour < //..
		if (hour < 12 && hour >= 6) {

			return MomentOfTheDay.MORNING;
		} else if (hour >= 12 && hour < 18) {
			return MomentOfTheDay.AFTERNOON;

		} else if (hour >= 18 && hour < 22) {
			return MomentOfTheDay.EVENING;

		} else {
			return MomentOfTheDay.NIGHT;
		}
	}

	/**
	 * The hour when the moment start.
	 */
	private final int startHour;

	/**
	 * s Build a new moment of the day :
	 *
	 * @param startHour
	 *            when the moment start.
	 */
	MomentOfTheDay(int startHour) {
		assert ((0 <= startHour) && (startHour <= 24));
		this.startHour = startHour;
	}
}
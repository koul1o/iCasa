package org.example.time;

/**
 * The MomentOfTheDay service is used to retrieve the moment of the day. It also
 * supports listeners that are notified when the moment of the day change.
 */

public interface MomentOfTheDayService {

	/**
	 * Gets the moment of the day.
	 *
	 * @return the moment of the day
	 */
	public MomentOfTheDay getMomentOfTheDay();

	public void setMomentOfTheDay(MomentOfTheDay mom);

	public int getTime();

	/**
	 * Register a listener that will be notified each time the current moment of
	 * the day changed.
	 *
	 * @param listener
	 *            the listener
	 */
	void register(MomentOfTheDayListener listener);

	/**
	 * Unregister a moment of the day listener.
	 *
	 * @param listener
	 *            the listener
	 */
	void unregister(MomentOfTheDayListener listener);

}
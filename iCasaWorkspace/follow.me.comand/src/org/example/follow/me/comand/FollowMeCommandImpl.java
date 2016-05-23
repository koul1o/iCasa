package org.example.follow.me.comand;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Requires;
import org.example.follow.me.manager.EnergyGoal;
import org.example.follow.me.manager.FollowMeAdministration;
import org.example.follow.me.manager.IlluminanceGoal;
import org.example.time.MomentOfTheDay;
import org.example.time.MomentOfTheDayService;

import com.example.bimary.follow.me.FollowMeConfiguration;

import fr.liglab.adele.icasa.command.handler.Command;
import fr.liglab.adele.icasa.command.handler.CommandProvider;

//Define this class as an implementation of a component :
@Component
// Create an instance of the component
@Instantiate(name = "follow.me.command")

// Use the handler command and declare the command as a command provider. The
// namespace is used to prevent name collision.
@CommandProvider(namespace = "followme")
public class FollowMeCommandImpl {

	// Declare a dependency to a FollowMeAdministration service
	@Requires
	private FollowMeAdministration m_administrationService;
	@Requires
	private FollowMeConfiguration config;
	@Requires
	private MomentOfTheDayService moment;
	
	
	/**
	 * Felix shell command implementation to sets the illuminance preference.
	 *
	 * @param goal
	 *            the new illuminance preference ("SOFT", "MEDIUM", "FULL")
	 */

	// Each command should start with a @Command annotation
	@Command
	public void setIP(String goal) {
		// The targeted goal
		IlluminanceGoal illuminanceGoal;

		switch (goal) {

		case "SOFT":
			illuminanceGoal = IlluminanceGoal.SOFT;
			break;
		case "MEDIUM":
			illuminanceGoal = IlluminanceGoal.MEDIUM;
			break;
		case "FULL":
			illuminanceGoal = IlluminanceGoal.FULL;
			break;
		default:
			throw new IllegalArgumentException("Illigal value: " + goal);

		}

		m_administrationService.setIlluminancePreference(illuminanceGoal);

	}

	@Command
	public void getIP() {

		System.out.println("The illuminance goal is: " + m_administrationService.getIlluminancePreference());
	}

	@Command
	public void getMaximumNumberOfLightsToTurnOn() {

		System.out.println("max lights: " + config.getMaximumNumberOfLightsToTurnOn());
	}

	@Command
	public void setMaximumNumberOfLightsToTurnOn(int ml) {

		config.setMaximumNumberOfLightsToTurnOn(ml);
	}

	@Command
	public void getEG() {

		System.out.println("The energy goal is: " + m_administrationService.getEnergyGoal());
	}

	@Command
	public void setEG(String goal) {

		EnergyGoal energyGoal;

		switch (goal) {

		case "LOW":
			energyGoal = EnergyGoal.LOW;
			break;
		case "MEDIUM":
			energyGoal = EnergyGoal.MEDIUM;
			break;
		case "HIGH":
			energyGoal = EnergyGoal.HIGH;
			break;
		default:
			throw new IllegalArgumentException("Illigal value: " + goal);

		}

		m_administrationService.setEnergyGoal(energyGoal);
	}

	// /** Component Lifecycle Method */
	// public void stop() {
	// System.out.println("command bundle stopped");
	// }
	//
	// /** Component Lifecycle Method */
	// public void start() {
	// System.out.println("command bundle started");
	// }

	@Command
	public void getmom() {

		System.out.println("Moment Of The day: " + moment.getMomentOfTheDay());
		System.out.println("The time: " + moment.getTime());
	}

	@Command
	public void setmom() {

		moment.setMomentOfTheDay(MomentOfTheDay.MORNING);
	}
}
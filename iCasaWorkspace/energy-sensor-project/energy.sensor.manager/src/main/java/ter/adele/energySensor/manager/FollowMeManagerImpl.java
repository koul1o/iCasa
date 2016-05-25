package ter.adele.energySensor.manager;

import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;

import fr.liglab.adele.icasa.service.location.PersonLocationService;
import fr.liglab.adele.icasa.service.preferences.Preferences;
import ter.adele.energySensor.followMe.FollowMeConfiguration;

@Instantiate(name = "energySensor manager")
@Provides
public class FollowMeManagerImpl implements FollowMeAdministration {

	/** Field for followMeConfiguration dependency */

	/** Injected field for the component property ilumGoal */

	/** Field for config dependency */
	// private FollowMeConfiguration config;
	IlluminanceGoal illuminanceGoal;
	EnergyGoal energyGoal;
	@Requires(optional = true)
	/** Field for config dependency */
	private FollowMeConfiguration config;
	@Requires(optional = true)
	/** Field for preferencesService dependency */
	private Preferences preferencesService;
	@Requires(optional = true)
	/** Field for personLocationService dependency */
	private PersonLocationService personLocationService;

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Manager stoped");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Manager started");

	}

	@Override
	public void setIlluminancePreference(IlluminanceGoal illuminanceGoal) {

		this.illuminanceGoal = illuminanceGoal;
		config.setMaximumNumberOfLightsToTurnOn(illuminanceGoal.getNumberOfLightsToTurnOn());
		config.setOnlyDim(illuminanceGoal.isOnlyBin());
		config.setPersentage(illuminanceGoal.getPersentage());
		System.out.println("Max Lights set to: " + config.getMaximumNumberOfLightsToTurnOn());
		System.out.println("Only dim is : " + config.isOnlyDim());
		System.out.println("Presentage is : " + config.getPersentage());
	}

	@Override
	public IlluminanceGoal getIlluminancePreference() {
		return illuminanceGoal;
	}

	@Override
	public void setEnergyGoal(EnergyGoal energyGoal) {
		this.energyGoal = energyGoal;
		config.setMaximumAllowedEnergyInRoom(energyGoal.getMaximumEnergyInRoom());
		// config.setMaxBinLights();
		System.out.println("Max Allowed Energy : " + config.getMaximumAllowedEnergyInRoom());

		// System.out.println("Max bin lights : " + config.getMaxBinLights());
	}

	@Override
	public EnergyGoal getEnergyGoal() {
		return energyGoal;
	}

}

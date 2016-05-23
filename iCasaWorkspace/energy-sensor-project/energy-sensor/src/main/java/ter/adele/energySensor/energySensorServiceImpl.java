package ter.adele.energySensor;

import com.google.gson.JsonObject;
import fr.liglab.adele.icasa.device.PowerObservable;
import fr.liglab.adele.icasa.service.scheduler.PeriodicRunnable;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Provides
@Instantiate(name = "SensorServiceInstance")
public class energySensorServiceImpl implements energySensorService, PeriodicRunnable {

	private String MotD;

	private String location;
	/** Field for observables dependency */

	@Requires(optional = true)
	private List<PowerObservable> observables;

	@Override
	public String getMotD() {
		return MotD;
	}

	@Override
	public void setMotD(String motD) {
		this.MotD = motD;
	}



	/** Bind Method for observables dependency */
	public void bindObservables(PowerObservable powerObservable, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Unbind Method for observables dependency */
	public void unbindObservables(PowerObservable powerObservable, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Energy sensor stoped");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Energy sensor started");
	}

	@Override
	public double calculateTottalEnergy() {
		double tottalConsumption = 0;
		for (PowerObservable powerObservable : observables) {

			tottalConsumption = tottalConsumption + powerObservable.getCurrentConsumption();

		}
		JsonObject event = new JsonObject();
		event.addProperty("time", MotD);
		event.addProperty("location", getLocation());
		event.addProperty("consumption", tottalConsumption);

		MqttToIbm cloud = new MqttToIbm(event, "energySensorData");

		boolean code = cloud.isSent();
		if (code == true) {
			System.out.println("Published the event successfully !");
		} else {
			System.out.println("Failed to publish the event......");
			System.exit(-1);
		}

		System.out.println("Tottal consumption in " + getLocation() + " at-> " + MotD + " is: " + tottalConsumption);
		return tottalConsumption;
	}

	@Override
	public void run() {
		if (calculateTottalEnergy() != 0) {
			calculateTottalEnergy();
		}

	}

	@Override
	public long getPeriod() {
		return 5;
	}

	@Override
	public TimeUnit getUnit() {
		return TimeUnit.SECONDS;
	}

	@Override
	public String setLocation(String location) {
		return this.location = location;

	}

	@Override
	public String getLocation() {
		return location;
	}

}

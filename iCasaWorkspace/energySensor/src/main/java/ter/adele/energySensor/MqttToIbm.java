package ter.adele.energySensor;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.ibm.iotf.client.app.ApplicationClient;

public class MqttToIbm {
	private static Logger logger = Logger.getLogger(MqttToIbm.class.getName());
	private boolean sent = false;

	/**
	 * Sends a JSON object to the cloud via MQTT
	 *
	 * @param event
	 *            The JSON object to be send to the cloud
	 * @param deviceId
	 *            A unique ID to recognize a device
	 */
	public MqttToIbm(JsonObject event, String deviceId) {
		Properties props = new Properties();
		props.put("org", "quickstart");

		ApplicationClient myClient = null;
		try {
			// Instantiate the class by passing the properties file
			myClient = new ApplicationClient(props);
			myClient.connect();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Client error: " + e.getMessage(), e);
			System.exit(-1);
		}

		// publish the event on behalf of device
		try {
			sent = myClient.publishEvent("icasa", deviceId, "blink", event);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Couldn't Publish event: " + e.getMessage(), e);
		}
	}

	/**
	 * Looks whether the data has been sent to the cloud (TRUE) or not(FALSE)
	 *
	 * @return A boolean with the result from the transaction
	 */
	public boolean isSent() {
		return sent;
	}
}

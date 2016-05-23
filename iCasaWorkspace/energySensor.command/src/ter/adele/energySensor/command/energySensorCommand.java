package ter.adele.energySensor.command;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Requires;

import fr.liglab.adele.icasa.command.handler.Command;
import fr.liglab.adele.icasa.command.handler.CommandProvider;
import ter.adele.energySensor.energySensorService;

//Define this class as an implementation of a component :
@Component
// Create an instance of the component
@Instantiate(name = "energySensor.command")

// Use the handler command and declare the command as a command provider. The
// namespace is used to prevent name collision.
@CommandProvider(namespace = "energySensor")
public class energySensorCommand {

	@Requires
	private energySensorService energySensorService;

	@Command
	public void getEC() {

		System.out.println("total energy consumption: " + energySensorService.calculateTottalEnergy());

	}

}

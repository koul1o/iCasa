package fr.liglab.adele.icasa.parent2;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Requires;

import fr.liglab.adele.icasa.command.handler.Command;
import fr.liglab.adele.icasa.command.handler.CommandProvider;
import ter.adele.energySensor.energySensorService;

@Component
@Instantiate(name = "parentCom")

/**
 * Hello world!
 *
 */
@CommandProvider(namespace = "mycommands")
public class App {
	@Requires(optional = true)
	private energySensorService en;

	@Command
	public void getme() {

		System.out.println("you get " + en.getMotD());
	}

	@Command
	public void setme(String motD) {
		en.setMotD(motD);
	}

}

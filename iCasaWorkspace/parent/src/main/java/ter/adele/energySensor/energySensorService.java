package ter.adele.energySensor;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

@Component
@Instantiate(name = "parentone")
@Provides
public class energySensorService {

	private String MotD;

	public String getMotD() {
		return MotD;
	}

	public void setMotD(String motD) {
		this.MotD = motD;
	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("parent sensor stoped");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("parent sensor started");
	}

}
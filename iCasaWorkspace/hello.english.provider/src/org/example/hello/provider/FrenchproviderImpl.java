package org.example.hello.provider;

import org.example.hello.service.Hello;

public class FrenchproviderImpl implements Hello {

	@Override
	public void sayHello(String name) {
		System.out.println("Bonjour " + name + "\n");
	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("The french hello service is stopping");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("The french hello service is starting");
	}

}

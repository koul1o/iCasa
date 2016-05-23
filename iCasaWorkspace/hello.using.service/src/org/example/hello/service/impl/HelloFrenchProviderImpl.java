package org.example.hello.service.impl;

import org.example.hello.service.Hello;

public class HelloFrenchProviderImpl implements Hello {

	/** Injected field for the service property lang */

	/** Injected field for the service property lang */
	private String lang;

	/** Injected field for the component property test */
	/** Injected field for the service property lang */

	@Override
	public void sayHello(String name) {
		System.out.println("Bonjour cher " + name);

	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("The french hello service is stoping");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("The french hello service is sttarting");
	}

}

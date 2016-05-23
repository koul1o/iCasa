package org.example.hello.service.impl;


import org.example.hello.service.Hello;

public class HelloGreekProviderImpl implements Hello {
	@Override
	public void sayHello(String name) {
		System.out.println("kalimera " + name);

	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("The greek hello service is stoping");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("The greek hello service is sttarting");
	}

}

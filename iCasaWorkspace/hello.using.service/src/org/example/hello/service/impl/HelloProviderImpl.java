package org.example.hello.service.impl;

import org.example.hello.service.Hello;

public class HelloProviderImpl implements Hello {
	private String lang;
	@Override
	public void sayHello(String name) {
		System.out.println("Hello dear " + name);
	}

	/** Component Lifecycle Method */
	public void stop() {
		
		System.out.println("The english hello service is stopping");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("The english hello service is starting");
	}

}

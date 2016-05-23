package org.example.hello.provider;

import org.example.hello.service.Hello;

public class HelloProviderImpl implements Hello {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name + "\n");
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

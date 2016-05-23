package org.example.hello.service;

public interface Hello {
	/**
	 * The property lang defines the language used by the service.
	 **/
	public static final String PROP_LANG = "lang";

	void sayHello(String name);
}
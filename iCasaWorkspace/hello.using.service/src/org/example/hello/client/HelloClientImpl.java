package org.example.hello.client;

import org.example.hello.service.Hello;
import java.util.Map;

public class HelloClientImpl implements Runnable {

	public HelloClientImpl(String m_name) {

	}

	public String getName() {

		return m_name;
	}

	/** Field for helloServices dependency */
	private Hello[] helloServices;

	/** Bind Method for null dependency */
	public void bindHello(Hello hello, Map properties) {
		System.out.println("New Provider language = " + properties.get(Hello.PROP_LANG));
	}

	/** Unbind Method for null dependency */
	public void unbindHello(Hello hello, Map properties) {
		System.out.println("Provider leaving language = " + properties.get(Hello.PROP_LANG));
	}

	public void askProvidersToSayHello() {
		for (int i = 0; i < 1; i++) {
			String client = m_name;
			if ("fr".equals(m_clang)) {
				second[i].sayHello(client);
				System.out.println("langue: " + m_clang);
			}

			else if ("el".equals(m_clang)) {
				thind[i].sayHello(client);
				System.out.println("glwssa pellath: " + m_clang);
			}
			else if ("en".equals(m_clang)) {
				helloServices[i].sayHello(client);
				System.out.println("language: " + m_clang);
			}

		}
	}

	/**
	 * When m_end is false and the component is started, the component ask
	 * providers to say hello on a regular basis. When m_end is true, the thread
	 * is stopped
	 */
	private boolean m_end = false;
	/** Injected field for the component property name */
	private String m_name;
	/** Injected field for the component property clang */
	private String m_clang;
	/** Field for helloServicesFr dependency */
	/** Field for thind dependency */
	private Hello[] thind;
	/** Field for second dependency */
	private Hello[] second;

	/** Field for helloServicesGr dependency */
	/** Component Lifecycle Method */
	public void start() {

		Thread t1 = new Thread(this, m_name);
		m_end = false;
		t1.start();

	}

	/** Component Lifecycle Method */
	public void stop() {
		m_end = true;
	}

	@Override
	public void run() {
		try {
			while (!m_end) {
				askProvidersToSayHello();
				Thread.sleep(3000);

			}
		} catch (InterruptedException e) {
			stop();
		}
	}


}

package org.example.hello.client;

import java.util.Map;

import org.example.hello.service.Hello;

public class HelloClientImpl implements Runnable {

	/** Field for helloServices dependency */
	private Hello[] helloServices;

	/** Bind Method for helloServices dependency */
	public void bindHello(Hello hello, Map properties) {
		System.out.println("New provider language = " + properties.get(Hello.PROP_LANG));
	}

	public void unbindHello(Hello hello, Map properties) {
		System.out.println("Provider leaving language = " + properties.get(Hello.PROP_LANG));
	}

	private void askProvidersToSayHello() {

		for (int i = 0; i < 1; i++) {
			if ("en".equals(m_clang)) {
				System.out.println("client lang is : " + m_clang);
				helloServicesEn[i].sayHello(m_name);
			} else if ("fr".equals(m_clang)) {
				System.out.println("client langue is : " + m_clang);
				helloServicesFr[i].sayHello(m_name);
			}
		}

	}

	private boolean m_end = false;
	/** Injected field for the component property name */
	private String m_name;
	/** Injected field for the component property clang */
	private String m_clang;
	/** Field for helloServicesFr dependency */
	private Hello[] helloServicesFr;
	/** Field for helloServicesEn dependency */
	private Hello[] helloServicesEn;

	/** Component Lifecycle Method */
	public void stop() {
		m_end = true;
	}

	/** Component Lifecycle Method */
	public void start() {
		Thread t = new Thread(this);
		m_end = false;
		t.start();
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

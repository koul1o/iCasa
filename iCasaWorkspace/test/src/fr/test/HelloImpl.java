package fr.test;

import fr.liglab.adele.icasa.device.light.BinaryLight;

public class HelloImpl {

	/** Field for binaryLight dependency */
	private BinaryLight binaryLight;
	/** Injected field for the component property lang */
	private String m_lang;

	/** Component Lifecycle Method */
	public void stop() {
		if ("fr".equals(m_lang)) {
			System.out.println("Au revoir le monde !");
		} else if ("gr".equals(m_lang)) {
			System.out.println("τα μελέ!");
		}

		else {
			System.out.println("Good bye World !");
		}
	}
	/** Component Lifecycle Method */
	public void start() {
		if ("fr".equals(m_lang)) {
			System.out.println("Bonjour le monde !");
		} else if ("gr".equals(m_lang)) {
			System.out.println("καλημέρα!");
		} else {
			System.out.println("hi there!");
		}
	}

}

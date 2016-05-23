package org.example.temperature.Controller;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import fr.liglab.adele.icasa.device.temperature.Cooler;
import fr.liglab.adele.icasa.device.temperature.Heater;
import fr.liglab.adele.icasa.device.temperature.Thermometer;
import fr.liglab.adele.icasa.service.scheduler.PeriodicRunnable;

public class TemperatureControllerImpl implements PeriodicRunnable {

	/** The name of the LOCATION property */
	public static final String LOCATION_PROPERTY_NAME = "Location";
	/** The name of the location for unknown value */
	public static final String LOCATION_UNKNOWN = "unknown";

	/** Field for cooler dependency */
	private Cooler[] cooler;
	/** Field for heater dependency */
	private Heater[] heater;
	/** Field for thermometer dependency */
	private Thermometer[] thermometer;

	@Override
	public void run() {
		roomTemperature();

	}

	@Override
	public long getPeriod() {
		return 5;
	}

	@Override
	public TimeUnit getUnit() {
		return TimeUnit.SECONDS;
	}

	/** Bind Method for cooler dependency */
	public void bindCooler(Cooler cooler, Map properties) {
		System.out.println("bind cooler" + cooler.getSerialNumber());
	}

	/** Unbind Method for cooler dependency */
	public void unbindCooler(Cooler cooler, Map properties) {
		System.out.println("unbind dimm light" + cooler.getSerialNumber());
	}

	/** Bind Method for thermometer dependency */
	public void bindThermometer(Thermometer thermometer, Map properties) {
		System.out.println("bind dimm thermometer" + thermometer.getSerialNumber());
	}

	/** Unbind Method for thermometer dependency */
	public void unbindThermometer(Thermometer thermometer, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Bind Method for heater dependency */
	public void bindHeater(Heater heater, Map properties) {
		System.out.println("bind dimm heater" + heater.getSerialNumber());
	}

	/** Unbind Method for heater dependency */
	public void unbindHeater(Heater heater, Map properties) {
		// TODO: Add your implementation code here
	}

	/** Component Lifecycle Method */
	public void stop() {
		System.out.println("Component temperatureControl stopped");
	}

	/** Component Lifecycle Method */
	public void start() {
		System.out.println("Component temperatureControl started");
	}

	public void roomTemperature() {
		for (int i = 0; i < thermometer.length; i++) {

			System.out.println("temperature in: " + thermometer[i].getPropertyValue(LOCATION_PROPERTY_NAME) + " is "
					+ thermometer[i].getTemperature());
		}
	}

}

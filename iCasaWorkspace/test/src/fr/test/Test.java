package fr.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static String getTime() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");

		LocalDateTime dateTime = LocalDateTime.now();

		String formattedDateTime = dateTime.format(formatter);
		return formattedDateTime;
	}

	public static void main(String[] args) {

		String formattedDateTime = Test.getTime();

		System.out.println("Time is: " + formattedDateTime);
	}
}

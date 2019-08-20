package com.rest.client;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

public class Facadeexample {

	public static final Double NANO_TO_MILLIS = 1000000.0;

	public static void main(String[] args) throws MalformedURLException, IOException {

		int i = 1;
		while (i <= 10) {
			loadtest();
			i++;
		}

	}

	private static void loadtest() throws MalformedURLException, IOException {
		// final StringBuffer response = new StringBuffer();
		// start timer
		long nanoStart = System.nanoTime();
		long milliStart = System.currentTimeMillis();

		// do work to be timed
		doWork();

		// stop timer
		long nanoEnd = System.nanoTime();
		long milliEnd = System.currentTimeMillis();

		// report response times
		long nanoTime = nanoEnd - nanoStart;
		long milliTime = milliEnd - milliStart;
		reportResponseTimes(nanoTime, milliTime);
	}

	private static void reportResponseTimes(long nanoTime, long milliTime) {
		// convert nanoseconds to milliseconds and display both times with three digits
		// of precision (microsecond)
		String nanoFormatted = String.format("%,.3f", nanoTime / NANO_TO_MILLIS);
		String milliFormatted = String.format("%,.3f", milliTime / 1.0);

		// System.out.println("Milliseconds using nanoTime(): " + nanoFormatted);
		System.out.println(milliFormatted);
	}

	private static void doWork() throws MalformedURLException, IOException {

		try {
			String s = Request.Get("https://reqres.in/api/users?page=1").connectTimeout(1000).socketTimeout(1000)
					.execute().returnContent().asString();
			// System.out.println(s);
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}

}

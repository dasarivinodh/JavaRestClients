package com.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Httpconnection {

	private static final String USER_AGENT = "Mozilla/5.0";
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
			URL obj = new URL("https://reqres.in/api/users?page=1");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			// System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print result
				// System.out.println(response.toString());
			} else {
				System.out.println("GET request not worked");
			}
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}
}

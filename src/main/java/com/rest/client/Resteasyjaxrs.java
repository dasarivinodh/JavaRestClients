package com.rest.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class Resteasyjaxrs {

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

			ClientRequest request = new ClientRequest("https://reqres.in/api/users?page=1");
			request.accept("application/json");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));
			String output;
			while ((output = br.readLine()) != null) {
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

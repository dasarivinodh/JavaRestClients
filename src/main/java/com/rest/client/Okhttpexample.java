package com.rest.client;

import java.io.IOException;
import java.net.MalformedURLException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttpexample {

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
		OkHttpClient client = new OkHttpClient();
		try {
			final String url = "https://reqres.in/api/users?page=1";
			Request request = new Request.Builder().url(url).build();
			try (Response response = client.newCall(request).execute()) {
				// System.out.println(response.body().string());
			}
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}

}

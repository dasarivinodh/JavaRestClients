package com.rest.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Springresttemplate {

	public static final Double NANO_TO_MILLIS = 1000000.0;

	public static void main(String[] args) throws MalformedURLException, IOException {

//		int i = 1;
//		while (i <= 10) {
//			loadtest();
//			i++;
//		}
		try {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://api.inmail-test.inmar.in/o/token/";
			URI uri = new URI(baseUrl);
			HttpHeaders headers = new HttpHeaders();
			headers.add("content-type", "application/x-www-form-urlencoded");
			headers.add("client_id",
					"tQIJM9ziSMpZgJjhjArgGH1WKQGcp7gMUOQPYI3l");
			HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
			ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
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
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "https://reqres.in/api/users?page=1";
			URI uri = new URI(baseUrl);
			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
			ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
		}
	}

}

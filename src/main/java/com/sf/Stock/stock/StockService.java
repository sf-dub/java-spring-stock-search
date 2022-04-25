package com.sf.Stock.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;

@Component
public class StockService {

	// Set non-changing properties we need to build api url
	private final String BASE_URL = "https://www.alphavantage.co/query?";
	private final String FUNC_OVERVIEW = "function=OVERVIEW&symbol=";
	private final String APIKEY = "&apikey=INSERT_YOUR_API_KEY";
	private final int timeOut = 10000;

	// This method should be used for validation, storage ect
	public String getTickerData(String ticker) throws IOException {

		// Get stock data
		String result = searchTicker(ticker);

		// Return data to controller for binding and display
		return result;
	}

	public String searchTicker(String ticker) throws IOException {

		// remove white space - for production there's much more security needed
		String cleanTicker = ticker.trim();

		// Build url
		URL request = new URL(BASE_URL + FUNC_OVERVIEW + cleanTicker + APIKEY);

		// Create connection
		URLConnection connection = request.openConnection();
		connection.setConnectTimeout(timeOut);
		connection.setReadTimeout(timeOut);

		// Read response into string builder for performance although not thread-safe
		// If multi-threading wrap in a synchronized block or use string buffer
		InputStreamReader inputStream = new InputStreamReader(connection.getInputStream(), "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStream);
		StringBuilder responseBuilder = new StringBuilder();

		String line;

		while ((line = bufferedReader.readLine()) != null) {
			responseBuilder.append(line);
		}

		bufferedReader.close();

		// Debug: System.out.println("Response: " + responseBuilder.toString());

		// Return String to getTickerData
		return responseBuilder.toString();

	}
}

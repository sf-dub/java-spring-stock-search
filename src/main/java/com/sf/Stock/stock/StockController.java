package com.sf.Stock.stock;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StockController {

	// Stock service handles business logic
	private final StockService stockService;
	
	// Map index.jsp to root dir localhost:8080
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String index() {
		return "index";
	}
	
	// Map submit to handle both user input and response
	@RequestMapping(value = "/submit", method = RequestMethod.POST) 
	public String response(Model model, String ticker) throws IOException {
		
	// Send user input to stock service and return result	
	String stockData = stockService.getTickerData(ticker);

	// Bind ticker and result data to be used in response.jsp
	model.addAttribute("ticker", ticker);
	model.addAttribute("stockData", stockData);
		
	return "response";
	}
	
	// Allow spring to create the StockService object
	@Autowired
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}

}

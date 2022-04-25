package com.sf.Stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		System.out.println("START BUILD");
		SpringApplication.run(StockApplication.class, args);
	}

}

package com.fdmgroup.activeviamproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project based on a calculator to find the value at risk (VaR) Note: Values
 * chosen below represent trade P&L values based on millions as an example
 */
public class Main {
	public static void main(String[] args) {
		// Defining some data using ListArrays.asList() for immutability
		List<Double> data = Arrays.asList(-7.2, 4.0, 5.5, 3.1, 4.4, 0.0, -3.0);
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		double var = varCalculator.calculateVaRForATrade(data);
		System.out.println("VaR for the trade:  " + data);
		System.out.println("is: " + var + " million");

		// Defining the data for portfolio trades
		List<List<Double>> dataFromPortfolio = new ArrayList<>();
		dataFromPortfolio.add(Arrays.asList(-1.0, 1.2, 0.8, -0.5, 0.3));
		dataFromPortfolio.add(Arrays.asList(0.5, 1.2, -2.8, 0.1, 1.1));
		dataFromPortfolio.add(Arrays.asList(2.0, -1.5, 3.6, -1.4, -0.3));
		dataFromPortfolio.add(Arrays.asList(1.1, 3.5, -1.8, 0.7, 1.3));
		double varPortfolio = varCalculator.calculateVaRForPortfolio(dataFromPortfolio);
		System.out.println("VaR for portfolio trades: " + dataFromPortfolio);
		System.out.println("is: " + (double) Math.round(varPortfolio * 10) / 10 + " million");

	}
}

package com.fdmgroup.activeviamproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaRCalculator {

	// Defining variable for level of confidence (e.g. 95%)
	private double confidenceLevel;

	// constructor
	public VaRCalculator(double confidenceLevel) {
//		super();
		if (confidenceLevel <= 0 || confidenceLevel >= 1) {
			throw new IllegalArgumentException("Ensure the confidence level must be between 0 and 1.");
		}
		this.confidenceLevel = confidenceLevel;
	}

	// method to calculate value at risk for one trade
	public double calculateVaRForATrade(List<Double> data) {
		// defensive mechanism to account for null values
		if (data == null || data.isEmpty()) {
			throw new IllegalArgumentException("The trade data cannot be empty");
		}
		// Sort data in ascending order
		Collections.sort(data);

		// logic to calculate index for VaR based on set confidence level
		// calculate index for VaR based on confidence level
		int position = (int) Math.ceil((1 - confidenceLevel) * data.size());
		// list has 0-indexing, so we will have to take away 1 from our position to suit
		// 0-indexing
		return data.get(position - 1);
	}

	// method to calculate VaR for multiple trades as in a portfolio
	public double calculateVaRForPortfolio(List<List<Double>> dataFromPortfolio) {
		// defensive mechanism to account for null values
		if (dataFromPortfolio == null || dataFromPortfolio.isEmpty()) {
			throw new IllegalArgumentException("Data for portfolio cannot be empty");
		}
		for (List<Double> eachTradeData : dataFromPortfolio) {
			if (eachTradeData == null || eachTradeData.isEmpty()) {
				throw new IllegalArgumentException("Each trades data cannot be empty");
			}
		}
		List<Double> summedProfitAndLoss = new ArrayList<>();
		// Obtain the total number for each trade
		int numberForEachTrade = dataFromPortfolio.get(0).size();

		// storing placeholder zero values in created list to add the
		// summed up profit and loss for each trade instance
		for (int i = 0; i < numberForEachTrade; i++) {
			summedProfitAndLoss.add((double) 0);
		}

		// adding the profit and loss across trades
		for (List<Double> eachTradeData : dataFromPortfolio) {
			for (int i = 0; i < numberForEachTrade; i++) {
				summedProfitAndLoss.set(i, summedProfitAndLoss.get(i) + eachTradeData.get(i));
			}
		}

		// sort the added profit and loss values in ascending order
		Collections.sort(summedProfitAndLoss);
		// calculate the position depending on confidence level
		int position = (int) Math.ceil((1 - confidenceLevel) * summedProfitAndLoss.size());
		return summedProfitAndLoss.get(position - 1);
	}

}

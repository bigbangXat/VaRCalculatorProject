package com.fdmgroup.activeviamproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit test for VaR calculator
 */
public class VaRCalculatorTest {

	@Test
	public void testCalculateValueAtRiskForSingleTrade() {
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		List<Double> data = Arrays.asList(-7.2, 1.5, 1.6, -0.6, 0.5);
		double expectedValue = -7.2;
		assertEquals(expectedValue, varCalculator.calculateVaRForATrade(data), 0.1);
	}

	@Test
	public void testCalculateValueAtRiskForPortfolioTrades() {
		List<List<Double>> portfolioData = Arrays.asList(Arrays.asList(-1.0, 1.2, 0.8, -0.5, 0.3),
				Arrays.asList(0.5, 1.2, -2.8, 0.1, 1.1), Arrays.asList(2.0, -1.5, 3.6, -1.4, -0.3),
				Arrays.asList(1.1, 3.5, -1.8, 0.7, 1.3));
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		double result = varCalculator.calculateVaRForPortfolio(portfolioData);
		assertEquals(-1.1, result, 0.1);
	}

	@Test
	public void testCalculateValueAtRiskForConfidenceLevelOf0_99() {
		VaRCalculator varCalculator = new VaRCalculator(0.99);
		List<Double> data = Arrays.asList(-2.0, 0.0, 0.5, 1.9, 0.7);
		double expectedValue = -2.0;
		assertEquals(expectedValue, varCalculator.calculateVaRForATrade(data), 0.1);

	}

	@Test
	public void testWithSingleElementInTradeData() {
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		List<Double> singleDataElement = Arrays.asList(2.0);
		assertEquals(2.0, varCalculator.calculateVaRForATrade(singleDataElement), 0.01);
	}

	@Test
	public void testSingleElementForPortfolioData() {
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		List<List<Double>> portfolioWithSingleDataElement = Arrays.asList(Arrays.asList(1.0));
		assertEquals(1.0, varCalculator.calculateVaRForPortfolio(portfolioWithSingleDataElement), 0.01);
	}

	@Test
	public void testCalculateValueAtRiskRForSingleTradeWithEmptyData() {
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		List<Double> emptyData = Arrays.asList();
		assertThrows(IllegalArgumentException.class, () -> {
			varCalculator.calculateVaRForATrade(emptyData);
		});
	}

	@Test
	public void testCalculateValueAtRiskForPortfolioWithEmptyData() {
		VaRCalculator varCalculator = new VaRCalculator(0.95);
		List<List<Double>> emptyPortfolioData = Arrays.asList();
		assertThrows(IllegalArgumentException.class, () -> {
			varCalculator.calculateVaRForPortfolio(emptyPortfolioData);
		});
	}
}

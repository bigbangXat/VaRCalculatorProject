# VaRCalculatorProject

## Description
The Value at Risk (VaR) calculator is a Java application that is purposed to calculate the potential risk of financial portfolio trades as well as individual trades. Aiming to help users assess potential losses in investments over a time frame given a confidence level.

##Key features
* VaR calculation for individual trades: Computation of VaR for single trades based on historical data provided within the application
* VaR calculation for portfolio (multiple trades): An extension of the core functionality in individual trades, where calculation of multiple trades is performed
* Confidence level can be configured: Allows for users to customise and check for multiple confidence levels
Also handles some edge cases (i.e. empty data and single element trades)

##Task Overview
Write a small application which will calculate VaR for a single trade. The confidence level
should be a configurable parameter, and the input data should contain a series of historical
values (you do not need to retrieve, compute or calculate these, only provide them as an
input to your application)

Extend the calculation to calculate the VaR for a portfolio (i.e. a group of trades). Your input
should contain historical values for multiple trades, however when called the function
should return VaR at the portfolio level - a single value. What do you notice about the
calculations?

##Getting started
Clone the repository and navigate to the project directory
Note: this project is under a maven build and runs on Java JDK 17 or higher 

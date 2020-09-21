package com.ds.problems;

/**
 * Given stock prices in an array find the price that give me highest profit
 * e.g. arr[] = {5,2,7,9,10,1,33,3}, Ans - 31 (buy=2, sell=33)
 * 
 * @author vaibhavsingh
 *
 */
public class FindMaxProfit {

	public void findMaxProfit(int stockPrices[]) {
		int buyPrice = stockPrices[0];
		int sellPrice = stockPrices[0];

		for (int i = 0; i < stockPrices.length; i++) {
			if (buyPrice < stockPrices[i]) {
				buyPrice = stockPrices[i];
			}

			if (sellPrice > stockPrices[i]) {
				sellPrice = stockPrices[i];
			}
		}

		System.out.println("Min Buy Price=" + buyPrice);
		System.out.println("Max Sell Price=" + sellPrice);
		System.out.println("Max Profit=" + (sellPrice - buyPrice));
	}

	public static void main(String args[]) {
		FindMaxProfit f = new FindMaxProfit();
		int stockPrices[] = { 5, 2, 7, 9, 10, 1, 33, 3 };
		f.findMaxProfit(stockPrices);
	}
}

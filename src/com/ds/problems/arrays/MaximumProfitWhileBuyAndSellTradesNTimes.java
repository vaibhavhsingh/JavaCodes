package com.ds.problems.arrays;

/**
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 * 
 * Buy sell stock n times to maximize profit
 * 
 * @author vaibhavsingh
 *
 */
public class MaximumProfitWhileBuyAndSellTradesNTimes {

	public static int solve(int[] A, int B) {
        int transactionCount=0;
        int size = A.length;
        int buyValue = A[0];
        int sellValue = -1;
        int profit = 0;
        int counter = 1; 
        while(transactionCount<B && counter < size) {
            for(int i=counter; i<size; i++) {
                if(buyValue < A[i]) {
                    break;
                } else {
                    buyValue = A[i];
                }
                counter++ ;
            }
            
            for(int i=counter; i<size; i++) {
                if(sellValue < A[i]) {
                    sellValue = A[i];
                } else {
                    break;
                }
                counter++;
            }
            
            if(buyValue >=0 && sellValue >= 0) {
                profit = sellValue - buyValue + profit;
            }
            sellValue = -1;
            buyValue = -1;
            transactionCount++;
            if(counter < size) {
            		buyValue = A[counter];
            }
        }
        return profit;
    }
	
	public static int maxProfitByTradingNTimes(int arr[], int n) {
		int size = arr.length;
		int profit[][] = new int[n+1][size+1];
		
		/*for(int i=0;i<=n;i++) {
			profit[i][0] = 0;
		}
		
		for(int j=0;j<=size;j++) {
			profit[0][j] = 0;
		}*/
		
		for (int i = 1; i <= n; i++) { 
            for (int j = 1; j < size; j++) { 
            		int maxSoFar = 0;
            		
            		for(int k=0; k<j; k++) {
            			maxSoFar = Math.max(maxSoFar, arr[j] - arr[k] + profit[i-1][k]);
            			
            			profit[i][j] = Math.max(profit[i][j-1], maxSoFar);
            		}
            }
        }
		
		return profit[n][size-1];
	}
	
	public static void main(String args[]) {
		int arr[] = {6, 8, 16, 1, 17, 12};
		//System.out.println(solve(arr, 1));
		System.out.println(maxProfitByTradingNTimes(arr, 2));
	}
}

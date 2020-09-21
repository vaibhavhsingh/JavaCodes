package com.ds.problems.greedyalgo;

/**
 * Given two integer arrays A and B of size N.
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * 
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 *
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
 * ending up at i again.
 * 
 * @author vaibhavsingh
 *
 */
public class GasStationProblem {

	public int findStartingPoint(int A[], int B[]) {
		int currentFuel = 0;
		int remainingFuel = 0;
		int total = 0;
		int start = 0;
		
		for(int i=0;i<A.length;i++) {
			remainingFuel = A[i] - B[i];
			
			if(currentFuel >=0) {
				currentFuel += remainingFuel;
			} else {
				currentFuel = remainingFuel;
				start = i;
			}
			total += remainingFuel;
		}
		
		return total >= 0 ? start : -1;
	}
	
	public static void main(String args[]) {
		//int A[] = {1, 2};
		//int B[] = {2, 1};
		int A[] = { 959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209};
		int B[]	= { 862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884 };
		
		GasStationProblem problem = new GasStationProblem();
		int startingStation = problem.findStartingPoint(A, B);
		
		System.out.println("Starting station = "+startingStation);
	}
}

package com.ds.problems;

/**
 * Egg Dropping Puzzle
 * 
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 * 
 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:
 * 
 * …..An egg that survives a fall can be used again.
 * …..A broken egg must be discarded.
 * …..The effect of a fall is the same for all eggs.
 * …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall.
 * …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
 * 
 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; 
 * if it survives, drop it from the second-floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. 
 * What is the least number of egg-droppings that is guaranteed to work in all cases?
 * 
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that the total number of trials are minimized.
 * 
 * @author vaibhavsingh
 *
 */
public class EggDroppingPuzzle {

	public int findMinimumAttempts(int eggCount, int floors) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		
		if(floors == 1 || floors == 0) {
			return floors;
		}
		
		if(eggCount == 1) {
			return floors;
		}
		
		for(int i=1; i<floors; i++) {
			res = Math.max(findMinimumAttempts(eggCount-1, i-1), findMinimumAttempts(eggCount, floors-i));
			
			if(res < min) {
				min = res;
			}
		}
		return 1 + min;
	}
	
	public static void main(String args[]) {
		EggDroppingPuzzle eggPuzzle = new EggDroppingPuzzle();
		System.out.println("Egg=2, Floor=5 => "+eggPuzzle.findMinimumAttempts(2, 5));
	}
}

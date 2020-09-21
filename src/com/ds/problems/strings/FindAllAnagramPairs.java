package com.ds.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindAllAnagramPairs {
	public int[][] anagrams(final String[] A) {
        HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
        for(int i = 0 ; i < A.length;i++){
            char[] t = A[i].toCharArray();
            Arrays.sort(t);
            String token = new String(t);
            ArrayList<Integer> val = null;
            if(map.get(token) == null){
                val = new ArrayList<Integer>();
            }
            else
                val = map.get(token);
           val.add(i+1);
           map.put(token,val);
        }
        int arr[][] = new int[map.size()][];
        ArrayList<ArrayList<Integer>> o = new ArrayList<ArrayList<Integer>>();
        int i=0;
        for(String l : map.keySet()){
            ArrayList<Integer> val = map.get(l);
            int row[] = new int[val.size()];
            for(int j=0;j<val.size();j++) {
                row[j] = val.get(j);
            }
            arr[i] = row;
            i++;
        }
        return arr;
    }
    
    private boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(s1.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    
    public void print(int arr[][]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + " ");		
			}
			System.out.println();
		}
	}
    
    public static void main(String args[]) {
    		FindAllAnagramPairs a = new FindAllAnagramPairs();
    		String arr[] = { "cat", "dog", "god", "tca" };
    		int pairs[][] = a.anagrams(arr);
    		a.print(pairs);
    }
 }

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

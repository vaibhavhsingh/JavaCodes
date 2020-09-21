package com.ds.problems.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class KthNonRepeatingCharacter {

	public char getNthNonRepeatingCharacter(String str, int nth) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for(int i=0; i<str.length() ; i++) {
			Integer count = map.get(str.charAt(i)) ;
			if(count != null) {
				map.put(str.charAt(i), ++count);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		
		int count = 0;
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) {
				count++;
				if(count == nth) {
					return entry.getKey();
				}
			}
		}
		return 0;
	}
	public static int MAX_CHAR = 256; 
	static int kthNonRepeating(String str, int k) 
    { 
        int n = str.length(); 
   
        // count[x] is going to store count of 
        // character 'x' in str. If x is not present, 
        // then it is going to store 0. 
        int[] count = new int[MAX_CHAR]; 
   
        // index[x] is going to store index of character 
        // 'x' in str.  If x is not  present or x is 
        // repeating, then it is going to store  a value 
        // (for example, length of string) that cannot be 
        // a valid index in str[] 
        int[] index = new int[MAX_CHAR]; 
   
        // Initialize counts of all characters and indexes 
        // of non-repeating  characters. 
        for (int i = 0; i < MAX_CHAR; i++) 
        { 
            count[i] = 0; 
            index[i] = n;  // A value more than any index 
                           // in str[] 
        } 
   
        // Traverse the input string 
        for (int i = 0; i < n; i++) 
        { 
            // Find current character and increment its 
            // count 
            char x = str.charAt(i); 
            ++count[x]; 
   
            // If this is first occurrence, then set value 
            // in index as index of it. 
            if (count[x] == 1) 
                index[x] = i; 
   
            // If character repeats, then remove it from 
            // index[] 
            if (count[x] == 2) 
                index[x] = n; 
        } 
   
        // Sort index[] in increasing order.  This step 
        // takes O(1) time as size of index is 256 only 
        Arrays.sort(index); 
   
        // After sorting, if index[k-1] is value, then  
        // return it, else return -1. 
        return (index[k-1] != n)? index[k-1] : -1; 
    } 
	
	public static void main(String args[]) {
		KthNonRepeatingCharacter f = new KthNonRepeatingCharacter();
		System.out.print("GeeksForGeeks="+f.getNthNonRepeatingCharacter("GeeksForGeeks",2));
		
		String str = "geeksforgeeks"; 
        int k = 3; 
        int res = kthNonRepeating(str, k); 
          
        System.out.println(res == -1 ? "There are less than k non-repeating characters" : 
                           "k'th non-repeating character is  " + str.charAt(res)); 

	}
}

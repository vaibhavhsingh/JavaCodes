package com.ds.problems.numerical;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {

	public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int number = 0;
        int current = 0;
        int next = 0;
        for(int i=0;i<s.length();i++) {
        		current = map.get(s.charAt(i));
        		
            if(i+1!= s.length()) {
            		next = map.get(s.charAt(i+1));
	            if(current < next) {
	                number += (next - current);
	                i++;
	            } else {
	            		number += current;
	            }
            } else {
            		number += current;
            }
        }
        return number;
    }
	
	public static void main(String args[]) {
		RomanToNumber roman = new RomanToNumber();
		System.out.println(roman.romanToInt("XXIVI"));
	}
}

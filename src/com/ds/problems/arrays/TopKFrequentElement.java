package com.ds.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {

	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String str : words) {
            int count = map.getOrDefault(str, 0);
            map.put(str, ++count);
        }
        
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
           public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
               if (m2.getValue() == m1.getValue()) {
                   return m1.getKey().compareTo(m2.getKey());
               } else {
                    return (m2.getValue()).compareTo(m1.getValue());
               }
           }
        });
        
        List<String> result = new ArrayList<String>();
        for(int i=0;i<k;i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
	
	public static void main(String args[]) {
		String arr[] = {"i", "love", "leetcode", "i", "love", "coding"};
		int k=2;
		TopKFrequentElement frequent = new TopKFrequentElement();
		System.out.println(frequent.topKFrequent(arr, k));
	}
}

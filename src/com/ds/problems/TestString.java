package com.ds.problems;

import java.util.HashMap;
import java.util.Map;

public abstract class TestString {

	public String winner(String erica, String bob) {
		// Write your code here
		Map<String, Integer> map = new HashMap<>();
		map.put("E", 1);
		map.put("M", 3);
		map.put("H", 5);

		String winner = "Tie";
		int ericaTotalPoints = 0;
		int bobTotalPoints = 0;

		if ((erica == null && bob == null) || ("".equals(erica) && "".equals(bob))) {
			return winner;
		}
		char ch = 'E';
		for (int i = 0; i < erica.length() - 1; i++) {
			System.out.println(erica.charAt(i));
			ericaTotalPoints += map.get(String.valueOf(erica.charAt(i)));
			bobTotalPoints += map.get(String.valueOf(bob.charAt(i)));
		}

		if (ericaTotalPoints != bobTotalPoints) {
			if (ericaTotalPoints > bobTotalPoints) {
				winner = "Erica";
			} else {
				winner = "Bob";
			}
		}
		return winner;
	}

}

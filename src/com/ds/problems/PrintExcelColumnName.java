package com.ds.problems;

/**
 * Find Excel column name from a given column number
 * 
 * MS Excel columns has a pattern like A, B, C, …, Z, AA, AB, AC, …., AZ, BA, BB, … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.
 * Given a column number, find its corresponding Excel column name. Following are more examples.
 * 
 * Input          Output
 * 26             Z
 * 51             AY
 * 52             AZ
 * 80             CB
 * 676            YZ
 * 702            ZZ
 * 705            AAC
 * 
 * @author vaibhavsingh
 *
 */
public class PrintExcelColumnName {

	public String printColumnName(int number) {
		StringBuilder sb = new StringBuilder();
		while(number > 0) {
			if(number % 26 == 0) {
				sb.append("Z");
				number = number/26-1;
			} else {
				sb.append((char)((number%26-1)+'A'));
				number = number/26;	
			}
		}
		return sb.reverse().toString();
	}
	
	public static void main(String args[]) {
		PrintExcelColumnName print = new PrintExcelColumnName();
		System.out.println("26="+print.printColumnName(26));
		System.out.println("27="+print.printColumnName(27));
		System.out.println("28="+print.printColumnName(28));
		System.out.println("100="+print.printColumnName(100));
		System.out.println("676="+print.printColumnName(676));
	}
}

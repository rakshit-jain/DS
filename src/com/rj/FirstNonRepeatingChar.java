package com.rj;

public class FirstNonRepeatingChar {
	 public static void main(String args[]) throws Exception {
	        System.out.println(getFirstNonRepeatingChar("geeksforgeeks"));
	    }

	//Only for 26 english chars. Can be extended for all characters
	    static char getFirstNonRepeatingChar(String s) {
	        int[][] arr = new int[2][26];
	        int k = 1;
	        for (char ch : s.toCharArray()) { // store count of occurrences of each char and index of first occurrence
	            int i = ch - 'a';
	            arr[0][i]++;

	            if (arr[1][i] == 0) {
	                arr[1][i] = k;
	            }
	            k++;
	        }

	        int pos = 999;
	        int x = 0;
	        for (int i = 0; i < 26; i++) {
	            if (arr[1][i] > 0 && arr[0][i] == 1 && arr[1][i] < pos) {
	                pos = arr[1][i];
	                x = i;
	            }
	        }
	        return (char) ('a' + x);
	    }
}

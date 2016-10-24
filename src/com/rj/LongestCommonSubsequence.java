package com.rj;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
	static int L[][] ;
	public static void main(String[] args) {
		int a[] = {1,2,7,3,2,1};
		int b[] = {7,2,1,1,2,3};
		System.out.println("Length of common sequence is by 2^n is " + findLongestCommonLength(a, b, a.length, b.length));
		System.out.println("Length of common sequence is  by n2 is " + findLongestCommonLengthN2(a, b, a.length, b.length));
		for(String string : findLCS(a, b, a.length, b.length)){
			System.out.println(string);
		}
	}
	
	public static int findLongestCommonLength(int a[], int b[], int m, int n){
		if(m==0 || n== 0){
			return 0;
		}else if(a[m-1]== b[n-1]){
			return 1+findLongestCommonLength(a, b, m-1, n-1);
		}
		else {
			return findMax(findLongestCommonLength(a, b, m-1, n), findLongestCommonLength(a, b, m, n-1));
		}
	}
	
	
	public static int findLongestCommonLengthN2(int a[], int b[], int m, int n){
		int lis[][]= new int [m+1][n+1];
		for(int i=0; i<=m;i++){
			for(int j=0; j<=n;j++){
				if(i==0 || j==0){
					lis[i][j]=0;
				}
				else if(a[i-1]==b[j-1]){
					lis[i][j] = lis[i-1][j-1]+1;
				}else{
					lis[i][j] = findMax(lis[i-1][j], lis[i][j-1]);
					
				}
			}
		}
		L= lis;
		printSubsequence(a, b, m, n, lis);
		return lis[m][n];
	}

	private static void printSubsequence(int[] a, int[] b, int m, int n, int[][] lis) {
		int []result = new int[lis[m][n]];
		int i=m,j=n;
		int k=result.length-1;
		 while(i>0 && j>0){
			 if(a[i-1]==b[j-1]){
				 result[k]=a[i-1];
				 k--;
				 i--;
				 j--;
			 }else{
				 if(lis[i-1][j]> lis[i][j-1] ){
					 i--;
				 }else{
					 j--;
				 }
			 }
		 }
		 for (int z : result) {
			System.out.print(z);
		}
		 System.out.println();
	}
	
	static int findMax(int a , int b){
		return a>=b?a:b;
	}
	
	
	/* Returns Set containing all LCS for X[0..m-1], Y[0..n-1] */
	static Set<String> findLCS(int[] X, int[] Y, int m, int n)
	{
	    // construct a Set to store possible LCS
	    Set<String> s = new HashSet<>();
	 
	    // If we reaches end of either String, return
	    // a empty Set
	    if (m == 0 || n == 0)
	    {
	        s.add("");
	        return s;
	    }
	 
	    // If the last characters of X and Y are same
	    if (X[m - 1] == Y[n - 1])
	    {
	        // recurse for X[0..m-2] and Y[0..n-2] in
	        // the matrix
	        Set<String> tmp = findLCS(X, Y, m - 1, n - 1);
	 
	        // append current character to all possible LCS
	        // of subString X[0..m-2] and Y[0..n-2].
	        for (String str : tmp)
	            s.add(str + X[m - 1]);
	    }
	 
	    // If the last characters of X and Y are not same
	    else
	    {
	        // If LCS can be constructed from top side of
	        // the matrix, recurse for X[0..m-2] and Y[0..n-1]
	        if (L[m - 1][n] >= L[m][n - 1])
	        	s = findLCS(X, Y, m - 1, n);
	 
	        // If LCS can be constructed from left side of
	        // the matrix, recurse for X[0..m-1] and Y[0..n-2]
	        if (L[m][n - 1] >= L[m - 1][n])
	        {
	        	// merge two Sets if L[m-1][n] == L[m][n-1]
	        	// Note s will be empty if L[m-1][n] != L[m][n-1]
	        	Set<String> tmp = findLCS(X, Y, m, n - 1);
	             s.addAll(tmp);
	 
	        }
	    }
	    return s;
	}
	
}

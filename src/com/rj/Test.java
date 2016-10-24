package com.rj;

/*import java.util.Scanner;

 IMPORTANT: Multiple classes and nested static classes are supported 


 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Test {
	
	private static int n = 0;
	private static int col = 0;
	private static boolean[][] visited ;
	private static int[][] arr;
    public static void main(String args[] ) throws Exception {
        
         * Read input from stdin and provide input before running
	
	Scanner scan = new Scanner(System.in);
	int row = scan.nextInt();
	int col = scan.nextInt();
	arr = new int[row][col];
	visited = new boolean[row][col];
	for(int i = 0; i < row; i++) {
		for(int j = 0; j < col; j++) {
		arr[i][j] = scan.nextInt();
	 
		}
	}
        Integer.MAX_VALUE
        
        int result = 0;
        
        
        for(int i = 0; i < row; i++ ) {
        	for(int j=0; j < col; j++) {
        		
        		int cal = calculateMax(arr, i, j);
        		if(cal > result) {
        			result = cal; 
        		}
        	}
        }

        System.out.println(result);
    }
    
   private static int calculateMax(int[][] arr, int i, int j) {
    	
    	if(i < row && i >=0 && j >=0 && j < col && !visited[i][j] && arr[i][j] == 1 ) {
    		
    		visited[i][j] = true;
    		
    		return 1 +
    		 calculateMax(arr, i-1, j) + //up
    		 calculateMax(arr, i+1, j) + //down
    		 calculateMax(arr, i, j-1) + //left
    		 calculateMax(arr, i, j+1) + //right
    		 calculateMax(arr, i-1, j-1) + // up-left
    		 calculateMax(arr, i-1, j+1) + //up-right
    		 calculateMax(arr, i+1, j-1) + //down-left
    		 calculateMax(arr, i+1, j+1); //up
    		 
    	} else {
    		return 0;
    	}
    	
    }
}*/




import java.util.Scanner;


class Test {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
	 	int cases = scan.nextInt();
	 	
		for(int i=0;i<cases;i++){
        	int arrayLength = scan.nextInt();
        	int arr[] = new int [arrayLength];
        	for(int j=0; j<arrayLength; j++){
        		arr[j] = scan.nextInt();
        	}	
    		System.out.println(contiguesSum(arr));
    		System.out.println(nonContiguesSum(arr));
        	
			
		}
        
    }
    
    public static int nonContiguesSum(int[] arr) {
    	int maxSum = 0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] > 0) {
    			maxSum += arr[i];
    		}
    		
    	}
    	return maxSum;
    }
    public static int contiguesSum(int[] arr) {
    	int maxSum = 0;
    	int currentSum = 0;
    	
    	if(ifAllNeg(arr)) {
    		return getMin(arr);
    	}
    	
    	for(int i = 0; i < arr.length; i++) {
    		currentSum += arr[i];
    		
    		if(currentSum > maxSum) {
    			maxSum = currentSum;
    		}
    		if(currentSum < 0) {
    			currentSum = 0;
    		}
    	}
    	return maxSum;
    }
    
    public static boolean ifAllNeg(int[] arr) {
    	for(int i=0; i < arr.length; i++) {
    		if(arr[i] > 0) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static int getMin(int[] arr) {
    	int min = Integer.MAX_VALUE;
    	
    	for(int i=0; i < arr.length; i++) {
    		if(arr[i] < min) {
    			min = arr[i];
    		}
    	}
    	return min;
    } 
}



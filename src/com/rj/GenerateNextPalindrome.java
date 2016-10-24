package com.rj;

public class GenerateNextPalindrome {

	public static void generateNextPalindrome(int a[]){
		int size = a.length;
		int mid = size/2;
		int i = mid-1;
		int j = size %2==0? mid: mid+1;
		// firstly ignore the common digits.
		while(i>=0 && a[i] ==a[j]){
				i--;
				j++;
		}
	
		// check if copying left side to right is enough.
		//middle digit needs to be incremented for palindrome and when left is less than right.
		boolean incrementMiddle = false;
		if(i< 0 || a[i]< a[j]){
			incrementMiddle = true;
		}
		
		if(incrementMiddle){
			int left = mid-1;
			int right = -1;
			int carry=1;
			if(size%2==0){
				right = mid;
			}else{
				right = mid+1;
				a[mid] += carry;
				carry = a[mid]/10;
				a[mid] %= 10;
			}
			
			while(left >=0){
				a[left] += carry;
				carry = a[left]/10;
				a[left] %=10;
				a[right++] = a[left--] ;
			}
			
		}else{
			while(i>=0){
				a[j]= a[i];
				i--;
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] ={1,9,9,1};
		// Handle case of all 9 separately.
		generateNextPalindrome(a);
		for (int i : a) {
			System.out.print(i + "");
		}
	}
}


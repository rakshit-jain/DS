package com.rj;

public class ArrayInSpiral {

	
	public static void printInSpiral (int[][] arr, int row, int col){
		int top=0;
		int bottom = row-1;
		int left = 0;
		int right = col -1;
		int dir = 0;
		while(top<=bottom && left<=right){
			if(dir ==0){
				for(int i=left; i<= right ; i++){
					System.out.println(arr[top][i]);
				}
				top++;
			}
			else if(dir==1){
				for(int i=top; i<= bottom ; i++){
					System.out.println(arr[i][right]);
				}
				right--;
			}
			else if (dir ==2){
				for(int i=right; i>= left ; i--){
					System.out.println(arr[bottom][i]);
				}
				bottom --;
			}
			else{
				for(int i=bottom; i>= top ; i--){
					System.out.println(arr[i][left]);
				}
				left ++;
			}
			
			dir = (dir +1)%4;
		}
	}
	public static void main(String[] args) {
		int arr[][] = new int[][]{ {1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		// 1 02 03 04
		// 5 06 07 08
		// 9 10 11 12
		ArrayInSpiral.printInSpiral (arr, 3, 4);
	}
}



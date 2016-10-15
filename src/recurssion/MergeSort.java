package recurssion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = {2,4,3,1,5,9,8,7,0} ;
		mergeSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
	
	private static void mergeSort(int [] arr){
		int length = arr.length;
		if(length<2){
			return;
		}
		int mid = length/2;
		int left[] = Arrays.copyOfRange(arr, 0, mid);
		int right[] = Arrays.copyOfRange(arr, mid, length);
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
		
	}
	
	private static void merge(int[] left , int [] right, int[] sub){
		int leftLen = left.length;
		int rightLen = right.length;
		int i=0, j=0,k=0;
		while(i<leftLen && j<rightLen){
			if(left[i]<= right[j]){
				sub[k] = left[i];
				i++;
			}else{
				sub[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<leftLen){
			sub[k]= left[i];
			i++;
			k++;
		}
		
		while(j<rightLen){
			sub[k]= right[j];
			j++;
			k++;
		}
	}
}

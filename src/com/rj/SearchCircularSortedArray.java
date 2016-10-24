package com.rj;

public class SearchCircularSortedArray {

	private static int circularSearch(int [] arr, int item){
		int searchIndex = -1;
		int low = 0;
		int high = arr.length -1;
	
		while (low<=high){
			int mid = (low+high)/2;
			if(arr[mid] == item){
				searchIndex = mid;
				break;
			}
			if(arr[mid]< arr[high]){
				//right half is sorted
				if(item > arr[mid] && item <= arr[high]){
					//Search item is ion sorted half
					low = mid+1;
				}else{
					high = mid -1;
				}
			}else{
				if(item >= arr[low] && item < arr[mid]){
					high = mid -1;
				}else{
					low = mid +1;
				}
			}
		}
		
		return searchIndex;
	}
	
	public static void main(String[] args) {
		int arr[] = new int []{6,7,1,2,3,4,5};
		int index = SearchCircularSortedArray.circularSearch(arr, 1);
		System.out.println("Item is at index " + index);
	}
}

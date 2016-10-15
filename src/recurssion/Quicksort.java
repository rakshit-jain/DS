package recurssion;

public class Quicksort {

	public static void quickSort(int arr[], int start, int end){
		if(start<end){
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}
	
	private static int partition(int arr[], int start, int end){
		int pIndex = start;
		for(int i=start; i<end; i++){
			// End of Array is chosen as pivot.
			if(arr[i] <= arr[end]){
				int temp = arr[i];
				arr[i]= arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end]= temp;
		
		return pIndex;
	}
	
	public static void main(String[] args) {
		int arr[] = {4,2,5,1,1,-2,3,1};
		Quicksort.quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}

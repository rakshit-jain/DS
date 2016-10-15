package recurssion;

public class BinarySearch {

	public static void main(String[] args) {
		int a[]={1,2,3,4,4,4,5,6,7};
		System.out.println("Index -> " +search(a, 4));
	}
	private static int search(int a[], int searchValue){
		int result = -1;
		int low =0;
		int high= a.length;
		while(low<=high){
			int mid = (low + high)/2;
			if(a[mid]==searchValue){
				result = mid;
				//Right most search value 
				low= mid+1;
			}
			else if(searchValue<a[mid]){
				high = mid -1;
			}else{
				low = mid +1;
			}
		}
		
		return result;
	}
}

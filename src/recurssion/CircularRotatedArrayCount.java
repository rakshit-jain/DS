package recurssion;

public class CircularRotatedArrayCount {

	
	public static void main(String[] args) {
		int a[] = {5,1,2,3,4};
		System.out.println("Count is " + findRotationCount(a));
	}
	//8, 7, 2 3 4 5 
	private static int findRotationCount(int a[]){
		int result = -1;
		int low = 0;
		int length = a.length ;
		int high = length-1;
		
		while(low<=high){
			if(a[low]<=a[high]){
				result = low;
				break;
			}
			int mid = (low+high)/2;
			int next = (mid +1)%length;
			int prev = (mid +length -1)%length;
			
			if(a[mid]<=a[next] && a[mid]<=a[prev]){
				result = mid;
				break;
			}
			else if(a[mid]<= a[high]){
				high = mid-1;
			}
			else if(a[mid] >= a[low]){
				low = mid +1;
			}
			
		}
		return result;
	}
}

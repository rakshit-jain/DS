package recurssion;

public class MaxHeapify {

	public void heapifyMax(int a[], int node, int size) {
		int left = 2 * node + 1;
		int right = 2 * node + 2;
		int max = node;
		if (left < size && a[left] > a[node]) {
			max = left;
		}
		if (right < size && a[right] > a[max]) {
			max = right;
		}
		if (node != max) {
			int temp = a[node];
			a[node] = a[max];
			a[max] = temp;
			heapifyMax(a, max, size);
		}
	}

	public void heapSort(int a[]){
		buildMaxHeap(a);
		int size = a.length;
		for (int i = a.length - 1; i >= 1; i--) {
			int temp = a[0];
			a[0]=a[i];
			a[i]= temp;
			size--;
			heapifyMax(a, 0, size);
		}
	}
	public void buildMaxHeap(int a[]) {
		for (int i = a.length / 2; i >= 0; i--) {
			heapifyMax(a, i,a.length);
		}
	}

	public static void main(String[] args) {
		int a[] = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		MaxHeapify h = new MaxHeapify();
		h.heapSort(a);
		for (int i : a) {
			System.out.print(i +", ");
		}
	}
}
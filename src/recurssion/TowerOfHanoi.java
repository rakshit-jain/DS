package recurssion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		moveDisk(4, 'a', 'c', 'b');
	}

	static void moveDisk(int n, char from, char to, char aux) {
		if(n==1){
			System.out.println("Move disk from "+ from +" to "+ to);
			return;
		}
		// Move n-1 disk from a to b using c as auxiliary.
		moveDisk(n-1, from, aux, to);
		// Move nth disk from A to C
		System.out.println("Move disk from "+ from +" to "+ to);
		// Move n-1 disk from b to c using a as auxiliary.
		moveDisk(n-1, aux, to, from);
	}
}
 
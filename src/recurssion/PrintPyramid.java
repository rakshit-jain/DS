package recurssion;

public class PrintPyramid {

	public static void main(String[] args) {
		for (int i=0 ;i<5 ;i++){
			for (int j=1; j<5-i;j++){
				System.out.print(" ");
			}
			for (int k=i; k>=0 ;k--){
				System.out.print("$ ");
			}
			System.out.println();
		}
		
		for (int i=0 ;i<5 ;i++){
			for (int j=i; j>=0;j--){
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i=0 ;i<5 ;i++){
			for (int j=1; j<5-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
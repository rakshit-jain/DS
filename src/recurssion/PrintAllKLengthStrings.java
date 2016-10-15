package recurssion;

class PrintAllKLengthStrings {

	// Driver method to test below methods
	public static void main(String[] args) {	
		
		
		String c = "abcd";
				try {
				   c.substring(0);
				}

				catch(Exception e) {
				   //

				} finally{

				   System.out.println(c);
				}
		System.out.println("First Test");
		char set[] = {'0', '1'};
		int k = 2;
		printAllKLength(set, k);
		
		 
	} 

	static void printAllKLength(char[] set,int k){
		permute(set, k, "");
	}
	
	static void permute(char[] set,int k, String prefix){
		if(k == 0){
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < set.length; i++) {
			String newPrefix = prefix + set[i];
			permute(set, k-1, newPrefix);
		}
	}
}
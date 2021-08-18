package other;

public class DiagonalStars {
	
	public static void main(String[] args) {
		printStars(5);
	}
	private static void printStars(int n) {
		
		if(n<5) System.out.println("Invalid Value");
		else {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(i==1 || i==n) {
						System.out.print("*");
					}
					else if(i==j || i+j-1==n) {
						System.out.print("*");
					}
					else if(j==1 || j==n) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println();
			}
		}
	}

}

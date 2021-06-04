package other;

public class CanSumTabulation {
	
	public static void main(String[] args) {
		
		int[] arr = {7,14};
		System.out.println(canSumTab(300, arr));
		
	}
	public static boolean canSumTab(int targetSum, int[] arr) {
		
		boolean[] table = new boolean[targetSum+1];
		table[0] = true;
		
		for ( int i = 0 ; i <= targetSum ; i++) {
			if ( table[i]) {
				for ( int w : arr) {
					if ( i+w <= targetSum) table[i+w] = true;
				}
			}
		}
		return table[targetSum];
	}

}

package other1;

public class GridTravelerTabulation {
	
	public static void main(String[] args) {
		
		System.out.println(gridTraTab(18, 18));
	}
	private static long gridTraTab(int m, int n) {
		
		long[][] table = new long[m+1][n+1];
		
		table[1][1] = 1;
		
		for ( int i = 0 ; i <= m ; i++) {
			for ( int j = 0 ; j <= n ; j++) {
				long current = table[i][j];
				if ( j + 1 <= n) table[i][j+1] += current;
				if ( i + 1 <= m) table[i+1][j] += current;	
			}
		}	
		return table[m][n];
	}
}

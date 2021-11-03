package arrayQuestions;

public class LongestPathQuestion {
	
	private static int[][] DIRECTIONS = { {1,0}, {-1,0}, {0,1}, {0,-1}};
	
	// 3,4,5	0,0,0
	// 3,2,6	0,0,0

	public static void main(String[] args) {
		
		int[][] matrix = { {3,4,5}, {3,2,6}};
//		int[][] matrix2 =  { {3,3}, {4,2}, {5,6}};
		System.out.println(longestIncreasingPath(matrix));
		
	}
	private static int longestIncreasingPath(int[][] matrix) {
		
		if ( matrix == null || matrix.length == 0) return 0;
		int n = matrix.length, m = matrix[0].length, longestPath = 0;
		int[][] cache = new int[n][m];
		
		for ( int i = 0 ; i < n ; i++) {
			for ( int j = 0 ; j < m ; j++) {
				int longest = longestIncreasingPath(matrix, cache, n, m, i, j);
				longestPath = Math.max(longestPath, longest);
			}
		}
		
		return longestPath;
	}
	
	private static int longestIncreasingPath(int[][] matrix, int[][] cache, int n, int m, int i, int j) {
		
		if ( cache[i][j] > 0) return cache[i][j] ;
		int max = 0;
		
		for ( int[] direction : DIRECTIONS) {
			int x = direction[0] + i, y = direction[1] + j;
			if ( x > -1 && y > -1 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
				int longest = longestIncreasingPath(matrix, cache, n, m, x, y);
				max = Math.max(max, longest);
			}
		}
		cache[i][j] = max + 1;
		return cache[i][j];
		
	}
}

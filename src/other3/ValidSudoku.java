package other3;

//import java.util.Arrays;

public class ValidSudoku {
	
	//private static final int GRID_SIZE  = 9;
	
	public static void main(String[] args) {
		
		char[][] board = {
				{'7', '.', '2', '.', '5', '.', '6', '.', '.'},
				{'.', '.', '.', '.', '.', '3', '.', '.', '.'},
				{'1', '.', '.', '.', '.', '9', '5', '.', '.'},
				{'8', '.', '.', '.', '.', '.', '.', '9', '.'},
				{'.', '4', '3', '.', '.', '.', '7', '5', '.'},
				{'.', '9', '.', '.', '.', '.', '.', '.', '8'},
				{'.', '.', '9', '7', '.', '.', '.', '.', '5'},
				{'.', '.', '.', '2', '.', '.', '.', '.', '.'},
				{'.', '.', '7', '.', '4', '.', '2', '.', '3'},
		};
		//Arrays.sort(board);
		
		
		if(solveBoard(board)) {
			System.out.println("Solved successfully");
		} else {
			System.out.println("Unsolvable board");
		}
		
		printBoard(board);
	}
	
	
	
	private static void printBoard(char[][] board) {
		for(int row = 0 ; row < 9 ; row++) {
			if( row % 3 == 0 && row != 0) {
				System.out.println("-----------");
			}
				
			for(int column = 0 ; column < 9 ; column++) {
				if(column % 3 == 0 && column != 0) {
					System.out.print("|");
				}
					
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
		
	}

	private static boolean isNumberInRow(char[][] board, char number, int row) {
		for(int i = 0; i < 9 ; i++) {
			if(board[row][i] == number) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isNumberInColumn(char[][] board, char number, int column) {
		for(int i = 0; i < 9 ; i++) {
			if(board[i][column] == number) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isNumberInBox(char[][] board, char number, int row, int column) {
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;
		
		for(int i = localBoxRow; i < localBoxRow + 3 ; i++) {
			for(int j = localBoxColumn; j < localBoxColumn ; j++) {
				if(board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isValidPlacement(char[][] board, char number, int row, int column) {
		return !isNumberInRow(board, number, row) && 
				!isNumberInColumn(board, number, column) &&
				!isNumberInBox(board, number, row, column);
	}
	
	private static boolean solveBoard(char[][] board) {
		for(int row = 0 ; row < 9 ; row++) {
			for(int column = 0 ; column < 9 ; column++) {
				if(board[row][column] == '.') {
					for(char numberToTry = '1' ; numberToTry <= '9' ; numberToTry++) {
						if(isValidPlacement(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;
							
							if(solveBoard(board)) {
								return true;
							} else {
								board[row][column] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	
	
}

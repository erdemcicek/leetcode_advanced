package other3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidSudokuLeetSolution {
	
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
		
		
		if(isValidSudoku(board)) {
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
	
	 public static boolean isValidSudoku(char[][] board) {
	        
	        //cannot use int[] directly as a key in hashmaps for java so use arraylist
	        HashMap<List<Integer>, HashSet<Character>> subgridMap = new HashMap<>();
	        HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
	        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
	        
	        
	        for(int i = 0; i < 9; i++){ 
	            for(int j = 0; j < 9; j++){
	                
	                char current_val = board[i][j];
	                List<Integer> grid_index = new ArrayList<>();
	                grid_index.add(i/3);
	                grid_index.add(j/3);
	                
	                if(current_val == '.'){continue;}
	                if(colMap.containsKey(j) && colMap.get(j).contains(current_val) || rowMap.containsKey(i) && rowMap.get(i).contains(current_val) || subgridMap.containsKey(grid_index) && subgridMap.get(grid_index).contains(current_val)){
	                    return false;
	                }
	                
	                //add to col
	                if(colMap.containsKey(j)){
	                    colMap.get(j).add(current_val);
	                }
	                else{
	                    colMap.put(j, new HashSet<>());
	                    colMap.get(j).add(current_val);
	                }
	                    
	                //add to row
	                if(rowMap.containsKey(i)){
	                    rowMap.get(i).add(current_val);
	                }
	                else{
	                    rowMap.put(i, new HashSet<>());
	                    rowMap.get(i).add(current_val);
	                }
	                      
	                //add to subgrid
	                if(subgridMap.containsKey(grid_index)){
	                    subgridMap.get(grid_index).add(current_val);   
	                } 
	                else{
	                    subgridMap.put(grid_index, new HashSet<>());
	                    subgridMap.get(grid_index).add(current_val);
	                }
	            }
	        }
	       
	        return true;
	    }

}

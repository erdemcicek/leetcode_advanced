package other3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ValidSudoku {
	
	public static void main(String[] args) {
		
		System.out.println(isValidSudoku(new char[][] {{'1', '2', '.'}, {'3', '.', '.'}, {'2', '1', '.'}}));
		
	}
	
	public static boolean isValidSudoku(char[][] c) {
		
		Character[][] d = new Character[c.length][c[0].length];
		for(int i = 0 ; i < c.length ; i++) {
			for(int j = 0 ; j < c[0].length ; j++) {
				d[i][j] = Character.valueOf(c[i][j]);
			}
		}
		
		for(int i = 0 ; i < d.length ; i++) {
			for(int j = 0 ; j < d[0].length ; j++) {
				if(Character.isDigit(d[i][j])) {
					boolean ch = Collections.frequency(Arrays.asList((d[i])), d[i][j]) == 1;
					if(!ch) return false;
				}
			}
		}
		
		return true;
	}
	
	
}

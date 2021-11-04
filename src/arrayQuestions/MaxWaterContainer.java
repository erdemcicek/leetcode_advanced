package arrayQuestions;

import java.util.Arrays;

public class MaxWaterContainer {
	
	public static void main(String[] args) {
		int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(heights));
		
	}
	
	private static int maxArea(int[] heights) {
		
		int left = 0, right = heights.length-1;
		int max = 0;
		
		while(left < right) {
			int lh = heights[left];
			int rh = heights[right];
			int w = right - left;
			int h = Math.min(rh, lh);
			int area = w * h;
			max = Math.max(max, area);
			
			if ( lh < rh) ++left;
			else if ( rh < lh) --right;
			else {
				++left;
				--right;
			}
		}
		return max;
	}
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_leetcode46 {
	
	public static void main(String[] args) {
		
		System.out.println(permute(new int[] {1,2,3}));
		
	}
	
	private static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		boolean[] vis = new boolean[nums.length];
		permutations(nums, vis, ans, list);
		
		return ans;
	}
	
	private static void permutations(int[] nums, boolean[] vis, List<List<Integer>> ans, List<Integer> list) {
		
		if(list.size() == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for(int i = 0 ; i < nums.length ; i++) {
			if(vis[i] == false) {
				vis[i] = true;
				list.add(nums[i]);
				permutations(nums, vis, ans, list);
				// backtrack
				vis[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
}

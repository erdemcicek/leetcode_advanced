package arrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSingleNumber {
	
	public static void main(String[] args) {
		
		int[] arr = {4, 3, 2, 4, 3};
		System.out.println(findSingle1(arr));
		System.out.println(findSingle2(arr));
		System.out.println(findSingle3(arr));
		System.out.println(findSingle4(arr));
	}
	
	// 1.Way --> with List
	private static int findSingle1(int[] arr) {
		
		List<Integer> list = new ArrayList<>();
		
		for(Integer element : arr) {
			if (!list.contains(element)) list.add(element);
			else list.remove(element);
		}
		
		return list.get(0);
	}
	
	// 2.Way --> with Map
	private static int findSingle2(int[] arr) {
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		for(Integer element : arr) {
//			if ( !hm.containsKey(element)) hm.put(element, 1);
//			else hm.put(element, hm.get(element) + 1);
			hm.put(element, hm.getOrDefault(element, 0) + 1);
		}
		
		for ( Integer element : hm.keySet()) {
			if ( hm.get(element) == 1) return element;
		}
		
		return 0;
	}
	
	// 3.Way --> with Set
	private static int findSingle3(int[] arr) {
		
		Set<Integer> set = new HashSet<>();
		
		int sumOfSet = 0, sumOfArray = 0;
		for (Integer element : arr) {
			if (!set.contains(element)) {
				set.add(element);
				sumOfSet += element;
			}
			sumOfArray += element;
		}
		return 2 * sumOfSet - sumOfArray;
	}
	
	// 4.Way --> Functional Programming
	private static int findSingle4(int[] arr) {
		
		int a = Arrays.stream(arr).distinct().sum(); // sumOfSet
		int b = Arrays.stream(arr).sum();            // sumOfArray
		
		return 2 * a - b;
	}
}
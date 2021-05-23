package arrayQuestions;

import java.util.Arrays;

public class MajorityVote {
	
	public static void main(String[] args) {
		
		Integer[] arr = {1,1,1,2,2,8}; // 7
		System.out.println(moreThanHalf(arr));
//		System.out.println(majorityElement(arr));
		
	}
	// 1.Way
	public static int majorityElement(Integer[] nums) {
		
		int candidate = 0;
		int count = 0;
		
		for ( int element : nums) {
			if ( count == 0) candidate = element;
			if ( element == candidate) ++count;
			else --count;
		}
//		return candidate; // If the program guarentees that array has an element that occurs more than 
						  // the half of the array. You can simply return candidate. If it is not the case
						  // you have to check this as shown below
		return doesHaveMaj(nums, candidate)?(candidate):0;
	}
	public static boolean doesHaveMaj(Integer[] nums, int candidate) {
		
		return Arrays.stream(nums).filter(t->t==candidate).count() > nums.length/2;
	}
	
	// 2.Way
	public static int moreThanHalf(Integer arr[]) {

//		List<Integer>list=Arrays.asList(arr); 
		
//		int a=list.size()/2;
//		list.stream().collect(Collectors.groupingBy(t->t,Collectors.counting())) //  1=4, 2=3
//				.entrySet().stream().filter(t->t.getValue()>a).max(Comparator.comparing(Entry::getValue))
//				.ifPresentOrElse(t->System.out.println(t.getKey()), ()->System.out.println(0));
//		return list.stream().collect(Collectors.groupingBy(t->t,Collectors.counting())) //  1=4, 2=3
//		.entrySet().stream().findAny(t->t.getValue()>a);
		return 0;
	}
	//

}

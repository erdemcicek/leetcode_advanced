package mathquestions;

/*
	 my recent interview question. They asked me to solve this with Python since it is in my resume
	4:50
	suffixes = [ "", "K", "M", "B", "T", "Q", "Qi", "Sx", "Sp", "Oc", "Non", "Dec" ];
	def convert(num):
	    #complete the function/method
	#1234 -> 1.23K #examples
	#print(convert(0)); # "0.00"
	print(convert(5678)); # 5.68K
	print(convert(-346273.3)); # "-346.27K"
	print(convert(43261072455745745672456.343462457245)); # "43.26Sx" 
 */

public class ConvertScientificNotations {
	
	public static void main(String[] args) {
		System.out.println(convert(43261072455745745672456000000000000.343462457245));
//		System.out.println(Double.MAX_VALUE);
	}
	private static String convert(double n) {
		String[] suffixes = {"", "K", "M", "B", "T", "Q", "Qi", "Sx", "Sp", "Oc", "Non", "Dec"};
		// 					      3    6    9    12 ...                                    33
		double x = Math.abs(n);
		int ind = 0;
		while(x>=1000) {
			x /= 1000;
			ind++;
		}
		
		return String.format("%.2f", n>0?x:-x) + suffixes[ind];
	}

}

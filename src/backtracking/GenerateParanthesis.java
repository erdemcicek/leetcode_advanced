package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParanthesis {
	
	public static void main(String[] args) {
//		System.out.println(generateParenthesis(3));
	}
	
	private static List<String> stackGeneratePar(int n){
		char[] p = new char[] {'(', ')'};
		Deque<Character> d = new ArrayDeque<>();
		
		
		
		return null;
	}
	
	public static List<String> generateParenthesis(int n) {
        
		char[] str = new char[2*n];
        List<String> res  = new ArrayList<>();
        
        genResult(res,str,n,n,0);
        
        return res;
    }
	
	public static void genResult(List<String> res, char[] str, int open, int close, int pos){
        if(pos==str.length){
            res.add(new String(str));
            return;
        }
        
        if(open>0 && open<=close){
            str[pos]='(';
            genResult(res,str,open-1,close,pos+1); // 2, 3, 1
        }
        if(close>0){
            str[pos]=')';
            genResult(res,str,open,close-1,pos+1); // 3, 2, 1
        }
    }

}

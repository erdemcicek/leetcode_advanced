package other2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestSubString {  // azABaabzaxZ

    public static String findSmallest(String str){ // azABaabza
    								   // a, b, ...x, z
        int[] capital = new int[26];   // 4, 1, ...1, 2
        
        							   // A, B, ... Z
        int[] lowercase = new int[26]; // 1, 1, ... 1

        for(char c : str.toCharArray()){
        	
            if(Character.isLowerCase(c)){
                lowercase[c-'a']++;
            }
            else {
                capital[c-'A']++;
            }
        }
        
        // these are the characters which have only lowecase
        // or only uppercase
        // they can never be part of the window
        Set<Character> invalidChars = new HashSet<>(); // x
        for(int i=0; i<26; i++){
            if( (capital[i] == 0)^(lowercase[i] == 0)){ // While capital exists, lowercase does not, or vice versa
                if(capital[i] == 0)  // a exists whereas A does not
                    invalidChars.add((char) (i+'a'));
                else
                    invalidChars.add((char) (i+'A'));
            }
        }

        Arrays.fill(capital, 0);
        Arrays.fill(lowercase, 0);
        
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = -1;
        int minWindowEnd = -1;

        int l = 0;
        for(int r=0; r<str.length(); r++){

            // delete everything in the window till now
            if(invalidChars.contains(str.charAt(r))){ // azABaabzaxZ

                while(l<=r){ // l=0, r=9

                    char leftChar = str.charAt(l);
                    if(!invalidChars.contains(leftChar)) {
                        if (Character.isLowerCase(leftChar))
                            lowercase[leftChar - 'a']--;
                        else
                            capital[leftChar - 'A']--;
                    }
                    l++;
                }
            }
            else{ // a, z, A, B, Z

                char rightChar = str.charAt(r);
                if(Character.isLowerCase(rightChar))
                    lowercase[rightChar-'a']++;
                else
                    capital[rightChar-'A']++;

                // shorten the window
                while(isBalanced(lowercase, capital) && l<=r){

                    int currWindowSize = r-l+1;
                    if(currWindowSize<minWindowLength){
                        minWindowLength = currWindowSize;
                        minWindowStart = l;
                        minWindowEnd = r;
                        
                        char leftChar = str.charAt(l);
                        if(Character.isLowerCase(leftChar))
                            lowercase[leftChar-'a']--;
                        else
                            capital[leftChar-'A']--;

                        l++;
                    }
                }
            }
        }
        
        if(minWindowLength == Integer.MAX_VALUE)
            return "-1";
        else
            return str.substring(minWindowStart, minWindowEnd+1);

    }

    public static boolean isBalanced(int[] capital, int[] lowercase){

        for(int i=0; i<26; i++){

            if((capital[i]==0)^(lowercase[i]==0))
                return false;
        }

        return true;
    }
    
    public static void main(String[] args) {

//        System.out.println(findSmallest("azABaabza"));
//        System.out.println(findSmallest("TacoCat"));
//        System.out.println(findSmallest("AcZCbaBz"));
        System.out.println(findSmallest("azABaabzaxZ")); // -1   	
    }
}

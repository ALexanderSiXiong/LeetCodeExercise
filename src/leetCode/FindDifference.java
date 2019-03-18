package leetCode;

import java.util.Arrays;

public class FindDifference {
    public static char findTheDifference(String s, String t) {

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        int length = t.length();

        for(int i = 0; i < length - 1; i++){
            if(sCharArray[i] != tCharArray[i]){
                return tCharArray[i];
            }
        }

        return tCharArray[length - 1];
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        System.out.println(findTheDifference(s,t));

    }


    class Solution {
        public char findTheDifference(String s, String t) {
            char[] cas = s.toCharArray();
            char[] cat = t.toCharArray();
            Arrays.sort(cas);
            Arrays.sort(cat);
            for (int i = 0; i < cas.length; i++) {
                if (cas[i] != cat[i]) return cat[i];
            }
            return cat[cat.length - 1];
        }
    }


}

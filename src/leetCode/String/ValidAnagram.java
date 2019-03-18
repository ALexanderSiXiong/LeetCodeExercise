package leetCode.String;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        for(int i = 0; i < s.length(); i++){
            if(sChar[i] != tChar[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int[] counter = new int[26];

        for(int i = 0; i < s.length(); i++){
            counter[sChar[i] - 'a']++;
            counter[tChar[i] - 'a']--;
        }

        for(int count:counter){
            if(count != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "ollhe";
        System.out.println(isAnagram2(a,b));
    }

}

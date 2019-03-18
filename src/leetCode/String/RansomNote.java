package leetCode.String;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int rLength = ransomNote.length();
        int mLength = magazine.length();
        if(mLength < rLength){
            return false;
        }
        int[] counter = new int[26];

        for(int i = 0; i < rLength; i++){
            counter[ransomNote.charAt(i) - 'a']++;
        }

        for(int i = 0; i < mLength; i++){
            if(counter[magazine.charAt(i)-'a'] != 0){
                counter[magazine.charAt(i)-'a']--;
            }
        }

        for(int i : counter){
            if(i > 0){
                return false;
            }
        }
        return true;

    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int rLength = ransomNote.length();
        int mLength = magazine.length();

        int[] counter = new int[26];

        for(int i = 0; i < mLength; i++){
            counter[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < rLength; i++){
            counter[ransomNote.charAt(i)-'a']--;
            if(counter[ransomNote.charAt(i)-'a'] == -1){
               return false;
            }
        }
        return true;

    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        List<Character> list = new ArrayList<>();
        for(char ch : magazine.toCharArray()) list.add(ch);
        for(char ch : ransomNote.toCharArray()) if(!list.remove((Character)ch)) return false;
        return true;
    }
    public static void main(String[] args) {
        String ransom = "aaa";
        String magazine = "aab";

        System.out.println(canConstruct(ransom,magazine));
    }
}

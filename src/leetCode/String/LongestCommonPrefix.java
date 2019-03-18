package leetCode.String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }

        String shortStr = findTheShortestStr(strs);

        String result = "";

        return result + shortStr;
    }

    private String findTheShortestStr(String[] strs){
        int shortest = 0;
        int shortestLength = strs[0].length();
        for(int index = 0; index < strs.length; index++){
            if(strs[index].length() < shortestLength){
                shortestLength = strs[index].length();
                shortest = index;
            }
        }
        return strs[shortest];
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);

        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];

        for(int i = 0; i < strs[0].length(); i++){
            if(firstWord.charAt(i) == lastWord.charAt(i)){
                result.append(firstWord.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String[] test = {"aca","aba"};
        LongestCommonPrefix example = new LongestCommonPrefix();
        System.out.println(example.longestCommonPrefix(test));
    }
}

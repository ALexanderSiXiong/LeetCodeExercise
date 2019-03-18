package leetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        return false;
    }

    public static String findPattern(String str){
        str = str + " ";
        System.out.println(str);
        ArrayList<String> list = new ArrayList<>();
        String cur = "";
        int start = 0;
        int end = 1;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == ' '){
                end = i;
                cur = str.substring(start, end);
                start = end + 1;
                list.add(cur);
            }

        }

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < list.size(); i++){
            if(map.get(list.get(i)) != null){
                map.put(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }


        for (String s : map.keySet()) {
            System.out.println("key:" + s);
            System.out.println("values:" + map.get(s));
        }


//        for(String i : list){
//            System.out.println(i);
//        }

        return null;
    }

    public static void main(String[] args) {
        String test = "dog cat cat dog";
        String test2 = "dog cat dog cat";
        System.out.println(findPattern(test2));
    }
}

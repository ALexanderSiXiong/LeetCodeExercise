package leetCode.String;

import java.util.*;

public class FirstUniqueCharacterInString {
    public static int firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] letterCounter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letterCounter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letterCounter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqueChar2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int slow = 0;
        int fast = 0;

        char[] charArray = s.toCharArray();
        int[] letterCounter = new int[26];

        while (fast < s.length()) {
            letterCounter[charArray[fast] - 'a']++;
            while (slow < s.length() && letterCounter[charArray[slow] - 'a'] > 1) {
                // 这里必须是while 例如s = abbcca
                // 如果是if就不行了
                slow++;
            }
            if (slow == s.length()) {
                return -1;
            }

            fast++;
        }
        return slow;
    }

    public static int firstUniqueChar3(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        char curr;
        Iterator iter;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("i = " + i);
            curr = s.charAt(i);
            System.out.println("curr = " + curr);
            System.out.println("door1 = " + set.contains(curr));
            if (set.contains(curr)) {
                if (map.get(curr) != null) {
                    map.remove(curr); // 出现了一次就把第一次加进去的删除了
                    // 对于'aaa'
                    // 第一次，添加
                    // 第二次，删除
                    // 第三次，因为map对应的这个key已经没有value了，它的map.size() = 0;
                }
            } else {
                map.put(curr, i); // 一次也没有出现就添加进去
                set.add(curr);
            }
            System.out.println("aaabbb"+map.size());
            iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                System.out.println("key = " + key);
                System.out.println("value = " + val);
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }

    public static int review1(String s){
        // two pointers
        if(s == null || s.length() == 0){
            int a = 1;
            return -1;
        }


        char[] charArray = s.toCharArray();
        int[] box = new int[26];

        int fast = 0;
        int slow = 0;

        while(fast < s.length()){
            box[charArray[fast] - 'a']++;

            // 这个地方要用while---能不能用别的东西替换？
            while(slow < s.length() && box[charArray[fast] - 'a'] > 1){
                slow++;
            }

            if (slow == s.length()){
                // 如果最后一个字符也相同的话，slow++会跑到边界外面
                return -1;
            }

            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        String s = "abbcca";
        String s1= "bbcca";

        System.out.println(firstUniqueChar3(s));

//        System.out.println("-----------------------");
//        Map<Character, Integer> map = new LinkedHashMap<>();
//
//        System.out.println(map.size());
//        map.put('a',1);
//        System.out.println(map.size());
//        map.remove('a');
//        System.out.println(map.size());


    }
}

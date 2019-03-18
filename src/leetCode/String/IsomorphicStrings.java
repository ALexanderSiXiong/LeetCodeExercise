package leetCode.String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map m = new HashMap();
        for (Integer i=0; i<s.length(); ++i)
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i)+"", i))
                return false;
        return true;
    }

    // 这里有个知识点暂时不能理解，就是为什么要用Integer，而不能用int
    public static boolean isIsomorphic2(String s , String t){
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();

        for(Integer i = 0; i < s.length(); i++){

            Integer one = first.put(s.charAt(i), i);
            Integer two = second.put(t.charAt(i), i);

            if(one != two){
                return false;
            }
        }

        return true;
    }

    public static boolean isIsomorphic3(String s , String t){
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int length = s.length();

        char[] sCounter = new char[256]; // 类似于计数器
        char[] tCounter = new char[256];

        for(int i = 0; i < length; i ++){
            char currentS = sArr[i]; // 当前的这一个字符
            char currentT = tArr[i];

            // 这一步不好想出来，需要彻底理解题目的意思
            // 我第一次对应你，我就创建出来一个对应关系
            // 我第二次对应你，我就来检查这种对应关系

            // All occurrences of a character must be replaced with another
            // character while preserving the order of characters.
            // No two characters may map to the same character but a character may map to itself.

            if(sCounter[currentS] == 0 && tCounter[currentT] == 0){
                sCounter[currentS] = currentT;
                // 如果当前的这一个字符还没有被记录，那么在s的counter里将其对应为t的某字符
                tCounter[currentT] = currentS;
                // 对于t的counter，同理
            } else {
                // 这个字符已经被记录过了
                // 所以开始比较，这个字符在sCounter里是否对应另外一个字符
                // tCounter里的该字符也是否对应着sCounter里的这个字符
//                if(sCounter[currentS] != currentT || tCounter[currentT] != currentS){
                if(sCounter[currentS] != currentT){ // 优化出来一点点空间
                    return false;
                }
            }

        }

        return true;
    }

    public static boolean review(String s, String t){
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        char[] sCounter = new char[256];
        char[] tCounter = new char[256];

        for(int i = 0; i < sArr.length; i++){
            char sCurr = sArr[i];
            char tCurr = tArr[i];

            if(sCounter[sCurr] == 0 && tCounter[tCurr] == 0){
                sCounter[sCurr] = tCurr;
                tCounter[tCurr] = sCurr;
            } else {
                if(sCounter[sCurr] != tCurr){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String first = "er";
        String second = "le";

        System.out.println(isIsomorphic3(first, second));
    }
}

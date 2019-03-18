package leetCode;

import java.util.HashMap;

public class RomantoInteger {

    public static int romanToInt(String s) {
        // 把东西放到一个 HashMap里面
        // 比较前后两个字母的值

        if (s == null || s.length() == 0){
            return -1;
        }

        int sum = 0;
        int preValue = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        if(s.length() == 1){
            return hashMap.get(s.charAt(0));
        }

        for(int i = s.length() - 1; i >= 0; i--){
            int currentValue = hashMap.get(s.charAt(i));

            if(currentValue >= preValue){
                sum += currentValue;
            } else {
                sum -= currentValue;
            }

            preValue = currentValue;

        }

        return sum;
    }
// VI - 1 + 5 = 6
//
//    I - 1
//    V - 5

// IV - 5 - 1 = 4
//
//      V = 5
//      I = 1

// CIV - 104
//   IV = 4
//   C = 100
//
// XCIV - 94
//
//   CIV = 104
//   X = 10
//

    public static void main(String[] args) {
        String s1 = "VI";
        String s2 = "IV";
        String s3 = "CIV";
        String s4 = "XCIV";
        String s5 = "I";


        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
        System.out.println(romanToInt(s4));
        System.out.println(romanToInt(s5));
    }
}

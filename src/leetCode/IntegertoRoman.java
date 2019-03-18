package leetCode;

public class IntegertoRoman {

    public static String intToRoman(int num) {
        if(num < 0){
            return null;
        }

        int[] numbers = {1000, 900, 500, 400,  100,  90,  50,   40,  10,   9,   5 ,   4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < numbers.length; i++){

            while(num >= numbers[i]){ // 这个地方是 >= 不然会跳到下一位
                num = num - numbers[i];
                res.append(strs[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 4;
        int n3 = 9;
        int n4 = 58;
        int n5 = 1994;

        System.out.println(intToRoman(n1));

        System.out.println(intToRoman(n2));

        System.out.println(intToRoman(n3));

        System.out.println(intToRoman(n4));

        System.out.println(intToRoman(n5));

        System.out.println(1*3 + 16 * 7 + 16 * 16 * 10 + 16*16*16 * 3
        );
    }

}

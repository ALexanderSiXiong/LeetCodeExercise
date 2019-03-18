package leetCode;

import java.sql.SQLOutput;

public class PalindromeNum {

    public static void main(String[] args) {
        //System.out.println(isPalindrome(211242112));
        String a = "qwerty";
        String b = "qwertyui";
        System.out.println(a.indexOf(b));
        System.out.println(b.indexOf(a));


    }

    public static boolean isPalindrome(int number) {
        // the number has only one digit
        if (0 <= number && number <= 9) {
            return true;
        }

        // the number end in 0 or the number is less than zero
        if (number % 10 == 0 || number < 0) {
            return false;
        }


        String numberString = String.valueOf(number);
        int start = 0;
        int end = numberString.length();

        do{
            //System.out.println("start dig = " + numberString.substring(start,start+1));
            //System.out.println("end dig = " + numberString.substring(end-1, end));

            // Always take only one digit in the provided number
            if(!(numberString.substring(start,start+1).equals(numberString.substring(end-1, end)))){
                System.out.println("aaa start dig = " + numberString.substring(start,start+1));
                System.out.println("aaa end dig = " + numberString.substring(end-1, end));
                return false;
            }

            start = start + 1;
            //System.out.println("start = " + start);
            end = end - 1;
            //System.out.println("end = " + end);
        } while (start < end);

        return true;
    }
}

package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null){
            return null;
        }

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if(digits[0] == 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }

    public String toString(int[] test){
        StringBuilder result = new StringBuilder();
        result.append("[");
        for(int i = 0; i < test.length; i++){
            System.out.print(test[i]);
            if(i != test.length - 1){
                System.out.print(",");
            }
        }

        result.append("]");

        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = {9};

        PlusOne test = new PlusOne();

        test.toString(test.plusOne(arr));



    }
}

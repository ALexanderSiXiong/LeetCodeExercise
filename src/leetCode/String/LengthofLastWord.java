package leetCode.String;

public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();
        s = " " + s;
        int stopPoint = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ' ') {
                stopPoint = i;
                break;
            }
        }

        return s.length() - stopPoint - 1;
    }

    public static int review(String s) {

        if (s.length() == 0 || s == null) {
            return 0;
        }

        s = " " + s;
        int tail = s.length() - 1;


        while (s.charAt(tail) == ' ') {
            tail--;
        }

        int head = tail;

        while (s.charAt(head) != ' ') {
            head--;
        }


        return tail - head;
    }


    public static void main(String[] args) {
        String test = "hello loo";
        System.out.println(lengthOfLastWord(test));
        System.out.println(review(test));
    }
}
// 10
// Hello World

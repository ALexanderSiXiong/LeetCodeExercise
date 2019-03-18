package leetCode.String;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();

        //Set<Character> volves = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        for (int head = 0, tail = s.length() - 1; head < tail; ) {
            if (!set.contains(chars[head])) {
                head++;
                continue;
            }

            if (!set.contains(chars[tail])) {
                tail--;
                continue;
            }

            swap(chars, head, tail);
            head++;
            tail--;
        }

        return String.valueOf(chars);
    }

    public String reverseVowels2(String s) {
        if (s.length() < 2) return s;

        char[] c = s.toCharArray();

        int head = 0;
        int tail = c.length - 1;


        while (head < tail) {

            if (!isVowel(c[head]))
                head++;
            else {
                while (!isVowel(c[tail]))
                    tail--;

                swap(c, head, tail);
                head++;
                tail--;
            }
        }
        return new String(c);
    }

    private void swap(char[] words, int i, int j) {
        char temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    private static boolean isVowel(char letter) {
        switch (letter) {
            case ('a'):
                return true;
            case ('e'):
                return true;
            case ('i'):
                return true;
            case ('o'):
                return true;
            case ('u'):
                return true;
            case ('A'):
                return true;
            case ('E'):
                return true;
            case ('I'):
                return true;
            case ('O'):
                return true;
            case ('U'):
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        String test = "hello";

        ReverseVowelsOfString oo = new ReverseVowelsOfString();
        System.out.println(oo.reverseVowels2(test));
    }


}

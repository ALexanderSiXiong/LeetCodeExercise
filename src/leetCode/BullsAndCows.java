package leetCode;

public class BullsAndCows {
    public static String getHint1(String secret, String guess) {

        int bulls = 0;
        int cows = 0;

        int[] secretArr = new int[secret.length()];
        int[] guessArr = new int[guess.length()];

        for(int i = 0; i < secret.length(); i++){
            secretArr[i] = (int)secret.charAt(i);
            guessArr[i] = (int)guess.charAt(i);
        }

        for (int i = 0; i < secretArr.length; i++) {
            if (secretArr[i] == guessArr[i]) {
                bulls++;
                secretArr[i] = -1;
                guessArr[i] = -2;
            }
        }

        for(int i = 0; i < secret.length(); i++){
                for (int j = 0; j < secretArr.length; j++) {
                    if(secretArr[i] == guessArr[j]){
                        cows++;
                        guessArr[j] = -2;
                        break;
                    }
                }
            }

        return bulls + "A" + cows + "B";
    }


    public static String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] counter = new int[10];

        char[] secretNum = secret.toCharArray();
        char[] guessNum = guess.toCharArray();

        for(int i = 0; i < secret.length(); i++){
            System.out.println();
            System.out.println("i = " + i);
            int s = secretNum[i] - '0';
            int g = guessNum[i] - '0';
            System.out.println("secret = " + s);
            System.out.println("guess = " + g);
            System.out.println();
            if(s == g){
                bulls++;
            } else {

                System.out.println("counter1["+g+"] = " + counter[g]);
                System.out.println("counter1["+s+"] = " + counter[s]);
                if(counter[g] < 0){
                    System.out.println(11);
                    cows++;
                }

                if(counter[s] > 0){
                    System.out.println(22);
                    cows++;
                }
                System.out.println("cows = " + cows);
                counter[g]++;
                counter[s]--;
                // 理解：
                // secret = 0423
                // guess  = 1011
                // 第一轮
                // guess = 1
                // secret = 0
                // counter[g]++ = counter[1]++ = 1  -> 说明在计数器里的1的位置上guess提供了一个1
                // counter[s]-- = counter[0]-- = -1  -> 在计数器里的0的位置secret的第一位差了一个数字可以对应
                // 那么，在 counter中 0 的位置缺少一个guess跟他对应，在 1 的位置已经存在了一个 1 可以和secret里不同位置的1对应

                // 第二轮
                // guess = 0
                // secret = 4
                // counter[g] = counter[0] = -1 < 0  上一轮secret提供的一个0，被这一轮guess的0用到了
                // counter[s] = counter[4] = 0 > 0   均不成立
                // counter[g]++ = counter[0]++ = 0   这里的0和 第一轮 secret第一个位置的0对应了，说明这个对应的数字已经被用掉了
                // counter[s]-- = counter[4]-- = -1

                System.out.println("counter2["+g+"] = " + counter[g]);
                System.out.println("counter2["+s+"] = " + counter[s]);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static String getHint3(String secret, String guess){
        int bulls = 0;
        int cows = 0;

        char[] secretChar = secret.toCharArray();
        char[] guessChar = guess.toCharArray();

        int[] counter = new int[10];

        for(int i = 0; i < secret.length(); i++){
            if(secretChar[i] == guessChar[i]){
                bulls++;
                secretChar[i] = '+';
                guessChar[i] = '-';
            }
        }

        for(int i = 0; i < secret.length(); i++){
            for(int j = 0; j < guess.length(); j++){
                if(secretChar[i] == guessChar[j]){
                    cows++;
                    guessChar[j] = '-';
                    break;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static String getHint4(String secret, String guess){
        int bulls = 0;
        int cows = 0;

        int[] counter = new int[10];

        char[] secretNum = secret.toCharArray();
        char[] guessNum = guess.toCharArray();

        for(int i = 0; i < secret.length(); i++){

            int s = (int)secretNum[i] - '0';
            int g = (int)guessNum[i] - '0';

            if(s == g){
                bulls++;
            } else {
                if(counter[g] < 0){
                    cows++;
                }

                if(counter[s] > 0){
                    cows++;
                }

                counter[s]--;
                counter[g]++;

            }
        }

        return  bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {

        String s = "1123";
        String g = "0001";

        System.out.println(getHint4(s,g));
    }
}

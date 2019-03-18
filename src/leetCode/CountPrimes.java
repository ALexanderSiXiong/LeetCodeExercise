package leetCode;

public class CountPrimes {

    public static void main(String[] args) {
        int a = countPrimes(11);
        System.out.println(a);

        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
    }

    public static int countPrimes(int originalNum){
        int count = 0;
        if(originalNum == 0 || originalNum == 1){
            return count;
        }

        int checkedNum = 2;

        do{
            if(isPrime(checkedNum)){
                count = count + 1;
            }
            checkedNum = checkedNum + 1;
        }while(checkedNum <= originalNum);
        return count;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

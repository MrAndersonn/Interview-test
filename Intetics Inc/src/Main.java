import java.util.Date;

public class Main {

    public static void main(String[] args) {
        int firstMultiplier=0;
        int secondMultiplier=0;
        int sum = 0;
        Date start = new Date();
        for (int i = 0; i <=99999; i++) {
            if (isPrimeNumber(i)) {
                for (int j = 99999; j>=0 ; j--) {
                    if (isPrimeNumber(j)) {
                        int k =i*j;
                        if (isPalindrome(k)&&k>sum){
                            sum=k;
                            firstMultiplier=i;
                            secondMultiplier=j;
                        }
                    }
                }
            }

        }
        System.out.println(new Date().getTime()-start.getTime());
        System.out.println(sum+" "+firstMultiplier+" "+secondMultiplier);
    }

    private static boolean isPalindrome(int number){
        int buff=number;
        int res=0;
        while (buff%10!=0){
            res=(res*10)+buff%10;
            buff=buff/10;

        }
        return res == number;
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2)
            return false;
        if (number==2) return true;
        if (number%2==0) return false;
        for (int i = 3; i*i <=number; i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

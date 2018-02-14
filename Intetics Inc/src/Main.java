import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        int firstMultiplier=0;
        int secondMultiplier=0;/*
        System.out.println(isPalindrome(999949999));
        System.out.println(isPrimeNumber(69143));
        System.out.println(isPrimeNumber(91009));*/
        StringBuilder out=new StringBuilder(" ") ;
        int c ;
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("C:\\Ph\\1test.txt"));
            
            while (true){
                if ((c=reader.read())!=-1) {
                    out.append((char) c);
                    System.out.print((char) c);
                }
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }


        System.exit(0);
        int sum = 0;
        Date start = new Date();
        for (int i = 0; i <=99999; i++) {
            if (isPrimeNumber(i)) {
                for (int j = 0; j<=99999 ; j++) {
                    if (isPrimeNumber(j)) {
                        int k =i*j;
                        if (isPalindrome(k)&&k>sum){
                            System.out.println("Sum"+ sum+ " : New sum"+ k );
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
        for (int i = 3; i<=number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

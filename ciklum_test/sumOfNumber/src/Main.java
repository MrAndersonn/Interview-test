public class Main {

    private long sum(long n){
        if (n<0)
            return 0;
        if (n==0)
            return 0;

        long result = 0;

        for (int i = 0; i <=n; i++) {
            long buff=i;

            while (buff!=0) {
                result+=buff%10;
                buff/=10;
            }
        }
        return result;
    }
}

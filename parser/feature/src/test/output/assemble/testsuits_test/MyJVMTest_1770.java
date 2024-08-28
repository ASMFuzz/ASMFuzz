import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_1770 {

    static long n = 9223372036854775807L;

    List<Long> factor(long n) {
        List<Long> flist = new ArrayList<>();
        while (n % 2L == 0) {
            flist.add(2L);
            n /= 2L;
        }
        long divisor = 3L;
        while (n > 1L) {
            long quotient = n / divisor;
            if (n % divisor == 0) {
                flist.add(divisor);
                n = quotient;
            } else if (quotient > divisor) {
                divisor += 2L;
            } else {
                flist.add(n);
                break;
            }
        }
        return flist;
    }

    boolean isPrime(long n) {
        List<Long> factors = factor(n);
        return (factors.size() == 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1770().isPrime(n));
    }
}

import java.util.*;

public class MyJVMTest_201 {

    static double[] values = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0.22394117095901023, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.008705513138929866, Double.NEGATIVE_INFINITY };

    static double d = 0.3485965972821584;

    static Random r = new Random(0);

    long m_exp(double[] values) {
        double res = 0;
        long start = System.nanoTime();
        for (int i = 0; i < values.length; i++) {
            res += Math.exp(values[i]);
        }
        long stop = System.nanoTime();
        d = res;
        return (stop - start) / 1000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_201().m_exp(values));
    }
}

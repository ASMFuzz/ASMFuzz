import java.util.*;

public class MyJVMTest_9352 {

    static double[] values = { 0.8856418521785702, 0d, 0d, Double.NEGATIVE_INFINITY, 0.1287168906170958, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.8605521463143888, Double.NaN };

    static double d = Double.MAX_VALUE;

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
        System.out.println(new MyJVMTest_9352().m_exp(values));
    }
}

import java.util.*;

public class MyJVMTest_7736 {

    static double[][] values = { { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE }, { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.NEGATIVE_INFINITY, 0d, 0.8472432150171636, 0.4828695501766217, 0.33006892735296156 } };

    static double d = Double.NEGATIVE_INFINITY;

    static Random r = new Random(0);

    long m_pow(double[][] values) {
        double res = 0;
        long start = System.nanoTime();
        for (int i = 0; i < values.length; i++) {
            res += Math.pow(values[i][0], values[i][1]);
        }
        long stop = System.nanoTime();
        d = res;
        return (stop - start) / 1000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7736().m_pow(values));
    }
}

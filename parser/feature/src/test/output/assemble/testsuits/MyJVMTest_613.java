import java.util.*;

public class MyJVMTest_613 {

    static int nb = 3;

    static double d = 0.47770047920051983;

    static Random r = new Random(0);

    double[][] pow_values(int nb) {
        double[][] res = new double[nb][2];
        for (int i = 0; i < nb; i++) {
            double ylogx = (1 + (r.nextDouble() * 2045)) - 1023;
            double x = Math.abs(Double.longBitsToDouble(r.nextLong()));
            while (x != x) {
                x = Math.abs(Double.longBitsToDouble(r.nextLong()));
            }
            double logx = Math.log(x) / Math.log(2);
            double y = ylogx / logx;
            res[i][0] = x;
            res[i][1] = y;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_613().pow_values(nb)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_613().pow_values(nb)[1]));
    }
}

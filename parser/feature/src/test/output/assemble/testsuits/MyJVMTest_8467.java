import java.util.*;

public class MyJVMTest_8467 {

    static int nb = 8;

    static double d = Double.MAX_VALUE;

    static Random r = new Random(0);

    double[] exp_values(int nb) {
        double[] res = new double[nb];
        for (int i = 0; i < nb; i++) {
            double ylogx = (1 + (r.nextDouble() * 2045)) - 1023;
            double x = Math.E;
            double logx = Math.log(x) / Math.log(2);
            double y = ylogx / logx;
            res[i] = y;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8467().exp_values(nb)));
    }
}

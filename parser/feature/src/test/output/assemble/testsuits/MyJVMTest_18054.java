import java.util.*;

public class MyJVMTest_18054 {

    static int nb = 0;

    static double d = 0.8210926033851443;

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
        System.out.println(Arrays.asList(new MyJVMTest_18054().exp_values(nb)));
    }
}

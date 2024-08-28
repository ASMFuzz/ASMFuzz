import java.lang.reflect.*;

public class MyJVMTest_10519 {

    static double v = Double.MIN_VALUE;

    double bh_sr_double(double v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10519().bh_sr_double(v));
    }
}

import java.util.Arrays;

public class MyJVMTest_10594 {

    static double X = java.lang.Math.PI;

    static double u = 0d;

    static boolean b = false;

    double[] getX() {
        return new double[] { X, X };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10594().getX()));
    }
}

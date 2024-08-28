import java.util.Arrays;

public class MyJVMTest_1383 {

    static double X = java.lang.Math.PI;

    static double u = Double.POSITIVE_INFINITY;

    static boolean b = false;

    double[] getX() {
        return new double[] { X, X };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1383().getX()));
    }
}

public class MyJVMTest_12629 {

    static double x = Double.NEGATIVE_INFINITY;

    double pause1(double x) {
        for (int k = 1; k <= 10000; k++) {
            x = x + 1.0;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12629().pause1(x));
    }
}

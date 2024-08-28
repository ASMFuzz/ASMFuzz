public class MyJVMTest_3304 {

    static double x = Double.MIN_VALUE;

    double pause1(double x) {
        for (int k = 1; k <= 10000; k++) {
            x = x + 1.0;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3304().pause1(x));
    }
}

public class MyJVMTest_11568 {

    static double x = Double.NaN;

    double pause2(double x) {
        for (int k = 1; k <= 10000; k++) {
            x = x - 1.0;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11568().pause2(x));
    }
}

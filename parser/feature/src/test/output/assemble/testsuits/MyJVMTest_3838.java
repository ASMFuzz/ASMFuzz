public class MyJVMTest_3838 {

    static double x = Double.MIN_VALUE;

    static double value = Double.MIN_VALUE;

    double add(double x) {
        value += x;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3838().add(x);
    }
}

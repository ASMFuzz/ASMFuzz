public class MyJVMTest_13180 {

    static double x = Double.POSITIVE_INFINITY;

    static double value = Double.MIN_VALUE;

    double add(double x) {
        value += x;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13180().add(x);
    }
}

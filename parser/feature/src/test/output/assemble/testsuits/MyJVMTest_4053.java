public class MyJVMTest_4053 {

    static double val = Double.NaN;

    static double pi = Double.POSITIVE_INFINITY;

    double add(double val) {
        pi += val;
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4053().add(val);
    }
}

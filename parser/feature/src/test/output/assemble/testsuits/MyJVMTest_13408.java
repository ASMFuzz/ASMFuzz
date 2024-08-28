public class MyJVMTest_13408 {

    static double val = Double.NEGATIVE_INFINITY;

    static double pi = Double.POSITIVE_INFINITY;

    double add(double val) {
        pi += val;
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13408().add(val);
    }
}

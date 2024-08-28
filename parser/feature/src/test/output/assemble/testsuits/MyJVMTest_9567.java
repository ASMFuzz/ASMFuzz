public class MyJVMTest_9567 {

    static double a = Double.NEGATIVE_INFINITY;

    static double b = 0.7017965824520502;

    double check(double a, double b) {
        if (a != b)
            throw new Error(a + " != " + b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9567().check(a, b);
    }
}

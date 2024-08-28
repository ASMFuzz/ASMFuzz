public class MyJVMTest_10050 {

    static double dx1 = 0.608641278079909;

    static double dy1 = Double.MAX_VALUE;

    static double dx2 = Double.NEGATIVE_INFINITY;

    static double dy2 = Double.MIN_VALUE;

    double checkColinear(double dx1, double dy1, double dx2, double dy2) {
        double threshold = 1.0E-10;
        if (!(dx1 * dx2 >= 0 && dy1 * dy2 >= 0 && Math.abs(dx1 * dy2 - dx2 * dy1) <= threshold)) {
            throw new RuntimeException("Angles difference is too much");
        }
        return dx2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10050().checkColinear(dx1, dy1, dx2, dy2);
    }
}

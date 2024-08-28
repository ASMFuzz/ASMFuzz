public class MyJVMTest_2460 {

    static double x = Double.NaN;

    static double y = Double.NEGATIVE_INFINITY;

    double add(double x, double y) {
        double rslt = x + y;
        if (Double.isInfinite(rslt)) {
            String msg = String.format("Real overflow: %s + %s.", x, y);
            throw new IllegalArgumentException(msg);
        }
        return (rslt == -0.0) ? 0.0 : rslt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2460().add(x, y));
    }
}

public class MyJVMTest_11727 {

    static double x = Double.MAX_VALUE;

    static double y = Double.NaN;

    double add(double x, double y) {
        double rslt = x + y;
        if (Double.isInfinite(rslt)) {
            String msg = String.format("Real overflow: %s + %s.", x, y);
            throw new IllegalArgumentException(msg);
        }
        return (rslt == -0.0) ? 0.0 : rslt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11727().add(x, y));
    }
}

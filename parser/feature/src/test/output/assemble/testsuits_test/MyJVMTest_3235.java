public class MyJVMTest_3235 {

    static double arg = Double.NEGATIVE_INFINITY;

    double test(double arg) {
        double strictResult = StrictMath.cos(arg);
        double mathResult = Math.cos(arg);
        if (Math.abs(strictResult - mathResult) > Math.ulp(strictResult))
            throw new AssertionError(mathResult + " while expecting " + strictResult);
        return strictResult;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3235().test(arg);
    }
}

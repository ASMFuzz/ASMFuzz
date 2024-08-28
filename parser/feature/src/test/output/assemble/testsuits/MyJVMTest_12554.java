public class MyJVMTest_12554 {

    static double arg = Double.MIN_VALUE;

    double test(double arg) {
        double strictResult = StrictMath.cos(arg);
        double mathResult = Math.cos(arg);
        if (Math.abs(strictResult - mathResult) > Math.ulp(strictResult))
            throw new AssertionError(mathResult + " while expecting " + strictResult);
        return strictResult;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12554().test(arg);
    }
}

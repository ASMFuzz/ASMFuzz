public class MyJVMTest_8087 {

    static double expected = 0.5922648519859989;

    static double got = Double.NaN;

    static String where = "2k-QQ!+yhL";

    double check(double expected, double got, String where) {
        if (got != expected) {
            throw new AssertionError(where + ": Non-strictfp " + got + " != " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8087().check(expected, got, where);
    }
}

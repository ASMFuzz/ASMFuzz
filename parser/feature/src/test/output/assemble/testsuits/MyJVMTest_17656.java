public class MyJVMTest_17656 {

    static double expected = 0.21414616214790683;

    static double got = 0.2967925752280193;

    static String where = "^9Ebd{ygp^";

    double check(double expected, double got, String where) {
        if (got != expected) {
            throw new AssertionError(where + ": Non-strictfp " + got + " != " + expected);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17656().check(expected, got, where);
    }
}

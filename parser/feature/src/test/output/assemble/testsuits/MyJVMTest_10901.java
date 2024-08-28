import java.util.Arrays;

public class MyJVMTest_10901 {

    static boolean expectNulls = true;

    static Object[] nulla = { 0, 0, -213405735, 2, 0, 3, 8, -510031171, 1, 0 };

    static Object[][] nullaa = { { 1, 2140586875, 0, 8, 0, 9, 1, 0, 9, 1 }, { 5, 7, 0, 0, 6, 0, 0, 0, 3, -2043213726 } };

    Object[][] processArrays(boolean expectNulls, Object[] nulla, Object[][] nullaa) {
        if (expectNulls) {
            if (nulla != null || nullaa != null) {
                throw new AssertionError("Null actual, but not null formal");
            }
        } else {
            if (nulla.length != 123 || nullaa.length != 321)
                throw new AssertionError("Wrong arrays received");
        }
        return nullaa;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10901().processArrays(expectNulls, nulla, nullaa);
    }
}

import java.util.Arrays;

public class MyJVMTest_1679 {

    static boolean expectNulls = true;

    static Object[] nulla = { 8, 9, 1, 2, 0, 5, 0, 6, 367405309, 0 };

    static Object[][] nullaa = { { 0, 0, 9, 4, 7, -588580927, 3, 0, 1630059484, 384721038 }, { 7, 0, 1, 3, 0, 7, 7, 6, 8, 1 } };

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
        new MyJVMTest_1679().processArrays(expectNulls, nulla, nullaa);
    }
}

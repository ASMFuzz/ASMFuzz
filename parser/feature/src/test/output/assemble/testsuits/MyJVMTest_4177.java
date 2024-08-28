public class MyJVMTest_4177 {

    static Object actual = 0;

    static Object expected = 1499479387;

    Object check(Object actual, Object expected) {
        if (actual != expected)
            throw new Error("expected: " + expected + "; actual = " + actual);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4177().check(actual, expected);
    }
}

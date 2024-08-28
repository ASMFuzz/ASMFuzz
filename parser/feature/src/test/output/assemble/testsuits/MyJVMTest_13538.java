public class MyJVMTest_13538 {

    static Object actual = 140964545;

    static Object expected = 94831811;

    Object check(Object actual, Object expected) {
        if (actual != expected)
            throw new Error("expected: " + expected + "; actual = " + actual);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13538().check(actual, expected);
    }
}

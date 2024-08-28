public class MyJVMTest_12763 {

    static String actual = "=k3QGX?vS&";

    static String expected = "TR\"=Tkbgdo";

    String verifyEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new Error("Expected " + expected + " but got " + actual);
        }
        System.out.println("Check passed for " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12763().verifyEquals(actual, expected);
    }
}

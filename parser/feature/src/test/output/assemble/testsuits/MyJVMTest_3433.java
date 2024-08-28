public class MyJVMTest_3433 {

    static String actual = "MN78tz[E.S";

    static String expected = "wCYe=,QVD2";

    String verifyEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new Error("Expected " + expected + " but got " + actual);
        }
        System.out.println("Check passed for " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3433().verifyEquals(actual, expected);
    }
}

public class MyJVMTest_17342 {

    static Object expected = 7;

    static Object got = 116835440;

    static boolean failed = false;

    Object equal(Object expected, Object got) {
        if (expected == null) {
            if (got == null) {
            } else {
                System.err.println("Error checking " + " serial data, expected:" + expected + ", got :" + got);
                failed = true;
            }
        } else if (!expected.equals(got)) {
            System.err.println("Error checking " + " serial data, expected:" + expected + ", got :" + got);
            failed = true;
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17342().equal(expected, got);
    }
}

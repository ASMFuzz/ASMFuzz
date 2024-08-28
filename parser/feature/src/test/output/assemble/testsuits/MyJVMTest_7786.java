public class MyJVMTest_7786 {

    static Object expected = 9;

    static Object got = 7;

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
        new MyJVMTest_7786().equal(expected, got);
    }
}

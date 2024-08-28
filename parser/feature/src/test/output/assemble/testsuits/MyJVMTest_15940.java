public class MyJVMTest_15940 {

    static boolean test = false;

    static String what = "WiuZov2r0o";

    static String prefix = "mDU\\x!GC>F";

    static String toString = "`tLg0) k#;";

    boolean assertFalse(boolean test, String what, String prefix) {
        if (test) {
            throw new RuntimeException("Expected false for " + what);
        }
        System.out.println(prefix + "Got expected " + what + ": " + test);
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15940().assertFalse(test, what, prefix);
    }
}

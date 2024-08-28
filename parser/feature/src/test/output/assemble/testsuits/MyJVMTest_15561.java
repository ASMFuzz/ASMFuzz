public class MyJVMTest_15561 {

    static boolean test = false;

    static String what = "yNB\\a}5k#V";

    static String prefix = "2=&0pfGZL!";

    static String toString = "<G.]`3/`zU";

    boolean assertTrue(boolean test, String what, String prefix) {
        if (!test) {
            throw new RuntimeException("Expected true for " + what);
        }
        System.out.println(prefix + "Got expected " + what + ": " + test);
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15561().assertTrue(test, what, prefix);
    }
}

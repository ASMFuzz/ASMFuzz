public class MyJVMTest_6452 {

    static boolean test = true;

    static String what = "BQ2SC~Pt/0";

    static String prefix = "E-<[d~HO(]";

    static String toString = "3`:%U=JJ>V";

    boolean assertFalse(boolean test, String what, String prefix) {
        if (test) {
            throw new RuntimeException("Expected false for " + what);
        }
        System.out.println(prefix + "Got expected " + what + ": " + test);
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6452().assertFalse(test, what, prefix);
    }
}

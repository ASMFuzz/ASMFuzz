public class MyJVMTest_2298 {

    static String what = "NO<J.mHwXj";

    static boolean ok = false;

    static String failure = "|]tcD&R^?z";

    String check(String what, boolean ok) {
        if (ok)
            System.out.println("OK: " + what);
        else {
            System.out.println("FAILED: " + what);
            failure = what;
        }
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2298().check(what, ok);
    }
}

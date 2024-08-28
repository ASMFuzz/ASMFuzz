public class MyJVMTest_11558 {

    static String what = "(?dLMi:M(O";

    static boolean ok = true;

    static String failure = "5yP'VK!v9w";

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
        new MyJVMTest_11558().check(what, ok);
    }
}

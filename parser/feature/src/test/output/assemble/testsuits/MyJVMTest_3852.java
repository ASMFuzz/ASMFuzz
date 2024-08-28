public class MyJVMTest_3852 {

    static String out = "4_9Ub;rSaz";

    static String text = ",h!-f<sUPH";

    static boolean expect = true;

    void error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
    }

    static int errors = 3;

    String check(String out, String text, boolean expect) {
        if (out.contains(text) != expect) {
            if (expect)
                error("expected string not found: " + text);
            else
                error("unexpected string found: " + text);
        }
        return text;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3852().check(out, text, expect);
    }
}

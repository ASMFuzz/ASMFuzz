public class MyJVMTest_13195 {

    static String out = ")gCH:.=/|N";

    static String text = "rFGH,B;>JL";

    static boolean expect = true;

    void error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
    }

    static int errors = 9;

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
        new MyJVMTest_13195().check(out, text, expect);
    }
}

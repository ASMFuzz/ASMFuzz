public class MyJVMTest_13371 {

    static String name = "Wr9UWjOIOj";

    static String expectedValue = "1&\\r\"\\$+lq";

    static String actualValue = "K_Ai2w7[QK";

    void errorHandling(String msg) {
        if (abort) {
            throw new RuntimeException("Error: " + msg);
        } else {
            error = true;
            System.err.println("**Error:" + msg);
        }
    }

    static boolean error = false;

    static boolean verbose = false;

    static boolean abort = false;

    static char R = '\u202F';

    String checkResult(String name, String expectedValue, String actualValue) {
        if (!expectedValue.equals(actualValue)) {
            errorHandling("Unexpected " + name + " value." + "\n\tExpected: \"" + expectedValue + "\"" + "\n\tGot:      \"" + actualValue + "\"");
        } else if (verbose) {
            System.out.println("  Okay : " + name + " = \"" + actualValue + "\"");
        }
        return actualValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13371().checkResult(name, expectedValue, actualValue);
    }
}

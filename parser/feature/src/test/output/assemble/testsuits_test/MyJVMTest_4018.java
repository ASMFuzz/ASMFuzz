public class MyJVMTest_4018 {

    static String name = "y{|,ixrNGg";

    static String expectedValue = "g4WcnRog<y";

    static String actualValue = "Y=sY\"Vr:tz";

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
        new MyJVMTest_4018().checkResult(name, expectedValue, actualValue);
    }
}

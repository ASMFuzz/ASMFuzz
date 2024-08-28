import javax.management.openmbean.*;

public class MyJVMTest_17159 {

    static boolean value = true;

    static String what = "9cp WA6Qcc";

    static String failed = "{*MR./ ~~j";

    String check(boolean value, String what) {
        if (value)
            System.out.println("OK: " + what);
        else {
            failed = what;
            System.out.println("FAILED: " + what);
        }
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17159().check(value, what);
    }
}

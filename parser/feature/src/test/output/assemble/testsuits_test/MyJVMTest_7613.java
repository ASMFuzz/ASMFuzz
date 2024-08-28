import javax.management.openmbean.*;

public class MyJVMTest_7613 {

    static boolean value = true;

    static String what = "rcKW)$2Xit";

    static String failed = "Vyd+%%hh_I";

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
        new MyJVMTest_7613().check(value, what);
    }
}

public class MyJVMTest_11465 {

    static String label = "aN5Xr6$2-\"";

    static T expect = null;

    static T found = null;

    static int errorCount = 5;

    <T> T checkEqual(String label, T expect, T found) {
        if ((found == null) ? (expect == null) : found.equals(expect))
            return;
        System.err.println("Error: mismatch");
        System.err.println("  expected: " + expect);
        System.err.println("     found: " + found);
        errorCount++;
        return found;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11465().checkEqual(label, expect, found);
    }
}

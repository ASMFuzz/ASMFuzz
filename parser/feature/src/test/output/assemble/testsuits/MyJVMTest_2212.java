public class MyJVMTest_2212 {

    static String label = "8l&RL/+ =T";

    static T expect = null;

    static T found = null;

    static int errorCount = 9;

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
        new MyJVMTest_2212().checkEqual(label, expect, found);
    }
}

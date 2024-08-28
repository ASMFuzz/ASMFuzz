public class MyJVMTest_17098 {

    static int codePoint = 7;

    static String method = "}b\"RD`0PVx";

    static boolean actual = true;

    static boolean expected = false;

    static int diffs = 0;

    int printDiff(int codePoint, String method, boolean actual, boolean expected) {
        System.out.println("Not equal at codePoint <" + Integer.toHexString(codePoint) + ">, method: " + method + ", actual: " + actual + ", expected: " + expected);
        diffs++;
        return codePoint;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17098().printDiff(codePoint, method, actual, expected);
    }
}

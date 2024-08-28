public class MyJVMTest_7556 {

    static int codePoint = 6;

    static String method = "2D[IBVp@0S";

    static boolean actual = false;

    static boolean expected = false;

    static int diffs = 0;

    int printDiff(int codePoint, String method, boolean actual, boolean expected) {
        System.out.println("Not equal at codePoint <" + Integer.toHexString(codePoint) + ">, method: " + method + ", actual: " + actual + ", expected: " + expected);
        diffs++;
        return codePoint;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7556().printDiff(codePoint, method, actual, expected);
    }
}

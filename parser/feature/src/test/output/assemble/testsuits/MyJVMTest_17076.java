public class MyJVMTest_17076 {

    static String name = "];vi-ZC3aF";

    static int m = 0;

    static boolean expected = true;

    static boolean res = false;

    boolean check_result(String name, int m, boolean expected, boolean res) {
        if (expected != res) {
            throw new RuntimeException("Bad result in " + name + " for m = " + m + " expected " + expected + " got " + res);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17076().check_result(name, m, expected, res);
    }
}

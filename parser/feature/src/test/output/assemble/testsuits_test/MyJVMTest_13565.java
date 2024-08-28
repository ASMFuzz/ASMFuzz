public class MyJVMTest_13565 {

    static String name = "#UunA){W);";

    static int x = -1976843168;

    static int m = 0;

    static boolean expected = true;

    static boolean res = true;

    boolean check_result(String name, int x, int m, boolean expected, boolean res) {
        if (expected != res) {
            throw new RuntimeException("Bad result in " + name + " for x =  " + x + " m = " + m + " expected " + expected + " got " + res);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13565().check_result(name, x, m, expected, res);
    }
}

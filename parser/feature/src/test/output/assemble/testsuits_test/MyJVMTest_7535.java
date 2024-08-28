public class MyJVMTest_7535 {

    static String name = " ;h7I>;*SR";

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
        new MyJVMTest_7535().check_result(name, m, expected, res);
    }
}

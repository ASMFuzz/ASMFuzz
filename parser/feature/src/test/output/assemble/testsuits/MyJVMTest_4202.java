public class MyJVMTest_4202 {

    static String name = "tPOhkM\\Id9";

    static int x = 0;

    static int m = 4;

    static boolean expected = true;

    static boolean res = false;

    boolean check_result(String name, int x, int m, boolean expected, boolean res) {
        if (expected != res) {
            throw new RuntimeException("Bad result in " + name + " for x =  " + x + " m = " + m + " expected " + expected + " got " + res);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4202().check_result(name, x, m, expected, res);
    }
}

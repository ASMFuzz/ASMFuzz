public class MyJVMTest_5000 {

    static int x = -1704404494;

    static int i = 5;

    static double d = 0.058558551829120176;

    static String s = "4WVe8tlzTV";

    int m(int x) throws Exception {
        System.out.println("called Baz.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5000().m(x);
    }
}

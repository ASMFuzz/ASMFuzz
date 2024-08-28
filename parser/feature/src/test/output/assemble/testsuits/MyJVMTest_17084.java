public class MyJVMTest_17084 {

    static int x = 0;

    static int arg = 123456;

    static int i = 9;

    static double d = 0d;

    static String s = "_Bk0]Zb`tp";

    static String ss = "RUM;t4voY8";

    int m(int x) throws Exception {
        System.out.println("called Baz.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17084().m(x);
    }
}

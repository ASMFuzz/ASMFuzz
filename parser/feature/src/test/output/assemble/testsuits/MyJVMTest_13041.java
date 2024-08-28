public class MyJVMTest_13041 {

    static int x = 5;

    static int arg = 123456;

    static int i = 7;

    static double d = 0.6382295895020976;

    static String s = ";5`j;EQ0}\"";

    static String ss = "-{4'VklP'O";

    int m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13041().m(x);
    }
}

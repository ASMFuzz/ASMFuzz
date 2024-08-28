public class MyJVMTest_10369 {

    static int x = 0;

    static int arg = 123456;

    static int i = 0;

    static double d = Double.MIN_VALUE;

    static String s = "[go%/w}'(X";

    static String ss = "kcvfJ?$oCG";

    int m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10369().m(x);
    }
}

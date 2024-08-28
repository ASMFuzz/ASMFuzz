public class MyJVMTest_3704 {

    static int x = 9;

    static int arg = 123456;

    static int i = 7;

    static double d = Double.POSITIVE_INFINITY;

    static String s = "UK?YD/CG1@";

    static String ss = "tzTc4O-[L:";

    int m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3704().m(x);
    }
}

public class MyJVMTest_1171 {

    static int x = 7;

    static int arg = 123456;

    static int i = 1;

    static double d = Double.NEGATIVE_INFINITY;

    static String s = ">}Y/2z9xd?";

    static String ss = "$0>\\)ZS,lv";

    int m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1171().m(x);
    }
}

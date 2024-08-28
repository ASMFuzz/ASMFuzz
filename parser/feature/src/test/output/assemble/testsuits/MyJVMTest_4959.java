public class MyJVMTest_4959 {

    static int x = 0;

    static int arg = 123456;

    static int i = 2;

    static double d = Double.MAX_VALUE;

    static String s = "IcI@/W9AHE";

    static String ss = "g:96p3FYjr";

    int sm(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.sm");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4959().sm(x);
    }
}

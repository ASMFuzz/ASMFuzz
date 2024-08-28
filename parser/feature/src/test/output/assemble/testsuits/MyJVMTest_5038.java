public class MyJVMTest_5038 {

    static int x = 0;

    static int i = 0;

    static double d = Double.NEGATIVE_INFINITY;

    static String s = "S'ylpr;qf1";

    static String ss = "68\\~MpU/lo";

    int sm(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.sm");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5038().sm(x);
    }
}

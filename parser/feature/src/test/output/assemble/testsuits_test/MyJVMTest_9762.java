public class MyJVMTest_9762 {

    static int x = 0;

    static int i = 0;

    static double d = 0d;

    static String s = "3]Na#C IQe";

    static String ss = "*}7qrU-m)x";

    int m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9762().m(x);
    }
}

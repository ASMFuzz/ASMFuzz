public class MyJVMTest_14407 {

    static int x = 0;

    static int i = 7;

    static double d = Double.NEGATIVE_INFINITY;

    static String s = "L[7^f/@cq6";

    int m(int x) throws Exception {
        System.out.println("called Baz.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14407().m(x);
    }
}

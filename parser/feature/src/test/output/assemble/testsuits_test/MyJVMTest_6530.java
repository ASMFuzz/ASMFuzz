public class MyJVMTest_6530 {

    void m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
    }

    static int arg = 123456;

    static int i = -14075392;

    static double d = Double.NEGATIVE_INFINITY;

    static String s = "1[SDCWqT:i";

    static String ss = "%8thkYTdev";

    void DoIt() throws Exception {
        m(arg);
        i = 1;
        d = 1.0;
        i += 5;
        i--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6530().DoIt();
    }
}

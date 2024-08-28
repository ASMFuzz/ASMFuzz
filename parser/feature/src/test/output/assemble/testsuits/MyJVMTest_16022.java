public class MyJVMTest_16022 {

    void m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
    }

    static int arg = 123456;

    static int i = 7;

    static double d = Double.MIN_VALUE;

    static String s = "2%xz-5RruJ";

    static String ss = "cAGqX [^6`";

    void DoIt() throws Exception {
        m(arg);
        i = 1;
        d = 1.0;
        i += 5;
        i--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16022().DoIt();
    }
}

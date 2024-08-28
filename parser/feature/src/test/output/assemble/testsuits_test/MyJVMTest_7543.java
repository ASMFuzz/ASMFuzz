public class MyJVMTest_7543 {

    static int x = 1;

    static int arg = 123456;

    static int i = 0;

    static double d = Double.NEGATIVE_INFINITY;

    static String s = "zF*J2~Pu\\[";

    static String ss = "e:${!7GluX";

    int m(int x) throws Exception {
        System.out.println("called Baz.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7543().m(x);
    }
}

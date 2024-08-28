public class MyJVMTest_596 {

    static int x = 7;

    static int i = 0;

    static double d = Double.MIN_VALUE;

    static String s = "w?S4<;U ^6";

    static String ss = "z6?MN+Rz]d";

    int m(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.m");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_596().m(x);
    }
}

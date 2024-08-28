public class MyJVMTest_14365 {

    static int x = 9;

    static int arg = 123456;

    static int i = 6;

    static double d = Double.NaN;

    static String s = "QM;-4S@!d>";

    static String ss = "<m,/eBkw\\q";

    int sm(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.sm");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14365().sm(x);
    }
}

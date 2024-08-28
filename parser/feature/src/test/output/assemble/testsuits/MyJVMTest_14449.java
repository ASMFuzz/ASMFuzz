public class MyJVMTest_14449 {

    static int x = 0;

    static int i = 0;

    static double d = Double.MAX_VALUE;

    static String s = "vP/9|E4~*+";

    static String ss = "Q6Cf#zRm`f";

    int sm(int x) throws Exception {
        System.out.println("called AccessMethodsLHS.Bar.sm");
        if (x != 123456)
            AccessMethodsLHS.fail("bad argument");
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14449().sm(x);
    }
}

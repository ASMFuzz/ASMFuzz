public class MyJVMTest_10561 {

    static String msg = "hz)u>c#=uy";

    static int errors = 1785674876;

    static String internalSource = "public class #O {public class #I {} }";

    String error(String msg) {
        System.err.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10561().error(msg);
    }
}

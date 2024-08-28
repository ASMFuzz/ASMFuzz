public class MyJVMTest_5878 {

    static String string = "^TV}d4_9U(";

    static boolean OPT_NOTHROW = false;

    static String id = "ZCF3gXJbf&";

    String err(String string) {
        if (OPT_NOTHROW) {
            System.out.println(id + " ERROR: " + string + " (continuing due to -n)");
        } else {
            throw new InternalError(id + ": " + string);
        }
        return string;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5878().err(string);
    }
}

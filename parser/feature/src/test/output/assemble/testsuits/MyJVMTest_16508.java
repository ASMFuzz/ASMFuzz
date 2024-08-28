public class MyJVMTest_16508 {

    static String msg = "]Cc6fXxKxZ";

    static int errors = 0;

    String error(final String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16508().error(msg);
    }
}

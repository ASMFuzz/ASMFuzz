public class MyJVMTest_6994 {

    static String msg = ";RKBz?$d9:";

    static int errors = 0;

    String error(final String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6994().error(msg);
    }
}

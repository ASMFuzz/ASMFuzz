public class MyJVMTest_7715 {

    static String msg = "$)9?_{N6rN";

    static int failures = 0;

    String fail(String msg) {
        failures++;
        System.out.println("FAIL: " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7715().fail(msg);
    }
}

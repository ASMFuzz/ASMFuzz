public class MyJVMTest_7784 {

    static String message = "vAm?@X<M!c";

    static Object args = 1;

    static int errors = 0;

    String fail(String message, Object... args) {
        errors++;
        System.out.printf(message, args);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7784().fail(message, args);
    }
}

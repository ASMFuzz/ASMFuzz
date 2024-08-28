public class MyJVMTest_17340 {

    static String message = "NPNa\"])}'$";

    static Object args = 3;

    static int errors = 0;

    String fail(String message, Object... args) {
        errors++;
        System.out.printf(message, args);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17340().fail(message, args);
    }
}

public class MyJVMTest_7083 {

    static String message = "g`UP'HME?s";

    static String eParam1 = "b}O?WylE-0";

    static Throwable eParam2 = new Throwable();

    static boolean eParam3 = true;

    static boolean eParam4 = false;

    static Exception e = new Exception(eParam1, eParam2, eParam3, eParam4);

    static int failed = 9, passed = 1;

    String failed(String message, Exception e) {
        System.out.println(message);
        System.out.println(e);
        failed++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7083().failed(message, e);
    }
}

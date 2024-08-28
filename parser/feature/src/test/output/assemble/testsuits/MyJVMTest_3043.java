public class MyJVMTest_3043 {

    static String message = "L!fMxL$RyM";

    static int errors = 0;

    String fail(String message) {
        errors++;
        System.err.println(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3043().fail(message);
    }
}

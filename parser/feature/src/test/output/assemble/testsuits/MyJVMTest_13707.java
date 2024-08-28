public class MyJVMTest_13707 {

    static String message = "f-KSrDy\" <";

    static int errors = 0;

    String error(String message) {
        System.err.println(message);
        errors++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13707().error(message);
    }
}

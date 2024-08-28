public class MyJVMTest_4333 {

    static String message = "Y/M5Rc:Ww:";

    static int errors = 7;

    String error(String message) {
        System.err.println(message);
        errors++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4333().error(message);
    }
}

public class MyJVMTest_8767 {

    static String message = "Y9l&oh_aoD";

    static boolean error = false;

    String error(String message) {
        System.err.println(message);
        error = true;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8767().error(message);
    }
}

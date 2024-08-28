public class MyJVMTest_10026 {

    static String message = "sGGNqYj@FJ";

    static boolean error = false;

    String error(String message) {
        System.err.println(message);
        error = true;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10026().error(message);
    }
}

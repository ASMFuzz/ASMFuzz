public class MyJVMTest_15163 {

    static String message = "[?(]j[\"-!k";

    String fail(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15163().fail(message);
    }
}

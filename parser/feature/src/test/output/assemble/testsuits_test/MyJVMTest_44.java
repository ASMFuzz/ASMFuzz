public class MyJVMTest_44 {

    static String message = "8d JrN@|4i";

    String reportException(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_44().reportException(message);
    }
}

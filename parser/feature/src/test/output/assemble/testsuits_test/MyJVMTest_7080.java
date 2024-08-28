public class MyJVMTest_7080 {

    static String message = ":Q\\XO#=KwR";

    String reportException(String message) {
        throw new RuntimeException("Test Failed. " + message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7080().reportException(message);
    }
}

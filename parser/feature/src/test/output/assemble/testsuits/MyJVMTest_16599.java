public class MyJVMTest_16599 {

    static String message = "Ta}$AD\\zo?";

    String reportException(String message) {
        throw new RuntimeException("Test Failed. " + message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16599().reportException(message);
    }
}

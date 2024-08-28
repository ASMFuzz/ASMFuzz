public class MyJVMTest_14110 {

    static String class_name = "T)T4U7BJgt";

    static String msg = "K1tp=8501u";

    String testClass(String class_name, String msg) throws Throwable {
        try {
            Class newClass = Class.forName(class_name);
            throw new RuntimeException("Expected VerifyError exception not thrown for " + msg);
        } catch (java.lang.VerifyError e) {
            if (!e.getMessage().contains("Bad type on operand stack")) {
                throw new RuntimeException("Unexpected VerifyError message for " + msg + ": " + e.getMessage());
            }
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14110().testClass(class_name, msg);
    }
}

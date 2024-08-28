public class MyJVMTest_4713 {

    static String class_name = "T,tLg=}z P";

    static String msg = ")rqM!&&4\"B";

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
        new MyJVMTest_4713().testClass(class_name, msg);
    }
}

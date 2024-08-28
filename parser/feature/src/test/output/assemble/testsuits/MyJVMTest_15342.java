public class MyJVMTest_15342 {

    static String className = "9ln7t|TSNh";

    static String cfeMessage = "4L~)@lVP]B";

    String runTest(String className, String cfeMessage) {
        try {
            Class newClass = Class.forName(className);
            throw new RuntimeException("Expected ClasFormatError exception not thrown");
        } catch (java.lang.ClassFormatError e) {
            String eMsg = e.getMessage();
            if (!eMsg.contains(cfeMessage)) {
                throw new RuntimeException("Unexpected exception: " + eMsg);
            }
        } catch (java.lang.ClassNotFoundException f) {
            throw new RuntimeException("Unexpected exception: " + f.getMessage());
        }
        return className;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15342().runTest(className, cfeMessage);
    }
}

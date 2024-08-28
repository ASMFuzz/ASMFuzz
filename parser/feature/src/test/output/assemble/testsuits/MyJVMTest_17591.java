public class MyJVMTest_17591 {

    static String className = ";^|q/tLt?B";

    static String cfeMessage = "{7m]\\Ge|U&";

    String runTest(String className, String cfeMessage) {
        try {
            Class newClass = Class.forName(className);
            throw new RuntimeException("Expected ClassFormatError exception not thrown");
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
        new MyJVMTest_17591().runTest(className, cfeMessage);
    }
}

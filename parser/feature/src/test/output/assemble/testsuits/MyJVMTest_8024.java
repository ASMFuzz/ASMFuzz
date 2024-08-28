public class MyJVMTest_8024 {

    static String className = "aUR(f:?$c#";

    static String cfeMessage = ")_H]IxJlf8";

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
        new MyJVMTest_8024().runTest(className, cfeMessage);
    }
}

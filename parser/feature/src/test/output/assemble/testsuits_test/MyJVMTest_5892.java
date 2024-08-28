public class MyJVMTest_5892 {

    static String className = "MOn4]2l`6~";

    static String cfeMessage = "C&(qfqVLbp";

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
        new MyJVMTest_5892().runTest(className, cfeMessage);
    }
}

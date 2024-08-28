public class MyJVMTest_3099 {

    static String className = "#i<c>,!r4@";

    boolean mustBeInvalid(String className) {
        System.out.println("Testing: " + className);
        try {
            Class.forName(className);
            System.out.println("ERROR: class " + className + " was loaded unexpectedly.");
            return false;
        } catch (Throwable t) {
            System.out.println("Expected exception:");
            t.printStackTrace();
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3099().mustBeInvalid(className));
    }
}

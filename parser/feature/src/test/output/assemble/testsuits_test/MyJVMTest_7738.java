public class MyJVMTest_7738 {

    static String errorMessage = "/<{A};$+!5";

    static String name = null;

    static String errors = new String();

    String appendError(String errorMessage) {
        errors += errorMessage;
        return errorMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7738().appendError(errorMessage);
    }
}

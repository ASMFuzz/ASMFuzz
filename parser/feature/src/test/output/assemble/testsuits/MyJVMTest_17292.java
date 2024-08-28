public class MyJVMTest_17292 {

    static String errorMessage = "V_1fV\\giKp";

    static String name = null;

    static String errors = new String();

    String appendError(String errorMessage) {
        errors += errorMessage;
        return errorMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17292().appendError(errorMessage);
    }
}

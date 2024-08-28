public class MyJVMTest_12682 {

    static String message = "JFE j^bv|x";

    String reportExceptionAndFail(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12682().reportExceptionAndFail(message);
    }
}

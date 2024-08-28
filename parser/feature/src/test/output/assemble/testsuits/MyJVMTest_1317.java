public class MyJVMTest_1317 {

    static String errMessage = "$0Rp{\\*R~?";

    String fail(String errMessage) {
        throw new RuntimeException(errMessage);
        return errMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1317().fail(errMessage);
    }
}

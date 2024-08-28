public class MyJVMTest_10521 {

    static String errMessage = "zJM&_*qC$u";

    String fail(String errMessage) {
        throw new RuntimeException(errMessage);
        return errMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10521().fail(errMessage);
    }
}

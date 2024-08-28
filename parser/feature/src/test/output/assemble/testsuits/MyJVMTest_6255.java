public class MyJVMTest_6255 {

    static String msg = "MNwyS$.yk1";

    String throwException(String msg) {
        throw new RuntimeException("test failed. " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6255().throwException(msg);
    }
}

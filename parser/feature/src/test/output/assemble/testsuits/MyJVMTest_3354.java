public class MyJVMTest_3354 {

    static String message = "}9!6w&Vf,/";

    String reportExceptionAndFail(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3354().reportExceptionAndFail(message);
    }
}

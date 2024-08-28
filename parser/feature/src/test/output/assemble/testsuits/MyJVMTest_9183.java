public class MyJVMTest_9183 {

    static String message = "0F[AVh.BsQ";

    String reportException(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9183().reportException(message);
    }
}

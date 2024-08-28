public class MyJVMTest_9094 {

    static String error = "o0Q99'u{u2";

    static int pos = 381879814;

    String handleError(String error, int pos) {
        throw new Error(error);
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9094().handleError(error, pos);
    }
}

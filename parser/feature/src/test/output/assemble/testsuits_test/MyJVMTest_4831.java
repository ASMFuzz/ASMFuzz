public class MyJVMTest_4831 {

    static String error = "FS`u/0JH--";

    static int pos = 1;

    String handleError(String error, int pos) {
        throw new Error(error);
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4831().handleError(error, pos);
    }
}

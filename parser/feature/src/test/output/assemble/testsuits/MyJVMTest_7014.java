public class MyJVMTest_7014 {

    static boolean throwError = false;

    void close() throws Exception {
        if (throwError) {
            throw new Error();
        } else {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7014().close();
    }
}

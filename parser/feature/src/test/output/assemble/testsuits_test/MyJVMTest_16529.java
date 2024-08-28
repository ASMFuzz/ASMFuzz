public class MyJVMTest_16529 {

    static boolean throwError = true;

    void close() throws Exception {
        if (throwError) {
            throw new Error();
        } else {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16529().close();
    }
}

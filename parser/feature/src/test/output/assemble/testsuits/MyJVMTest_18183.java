public class MyJVMTest_18183 {

    static Exception exception = new Exception();

    static boolean b = false;

    static int i = 0;

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected exception", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18183().exceptionThrown(exception);
    }
}

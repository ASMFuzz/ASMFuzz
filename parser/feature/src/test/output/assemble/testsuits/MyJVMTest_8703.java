public class MyJVMTest_8703 {

    static Exception e = new Exception();

    static boolean failed = false;

    static Exception failureException = null;

    Exception setStatusFailed(Exception e) {
        if (!failed) {
            failureException = e;
            failed = true;
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8703().setStatusFailed(e);
    }
}

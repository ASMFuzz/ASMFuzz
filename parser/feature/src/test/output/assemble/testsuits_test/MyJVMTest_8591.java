public class MyJVMTest_8591 {

    static String exceptionParam1Param1 = "Iy|TY/d$u)";

    static Throwable exceptionParam1 = new Throwable(exceptionParam1Param1);

    static Exception exception = new Exception(exceptionParam1);

    static boolean b = false;

    static int i = 4;

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected exception", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8591().exceptionThrown(exception);
    }
}

import java.beans.XMLDecoder;

public class MyJVMTest_6976 {

    static Throwable exceptionParam1Param1 = new Throwable();

    static Throwable exceptionParam1 = new Throwable(exceptionParam1Param1);

    static Exception exception = new Exception(exceptionParam1);

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected exception", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6976().exceptionThrown(exception);
    }
}

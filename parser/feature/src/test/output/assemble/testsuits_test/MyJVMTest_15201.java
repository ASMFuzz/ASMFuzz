import java.beans.ExceptionListener;

public class MyJVMTest_15201 {

    static Exception exception = new Exception();

    static byte[] buffer = {83,124,-102,-22,-92,111,-90,32,-38,-52};

    Exception exceptionThrown(Exception exception) {
        throw new Error(exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15201().exceptionThrown(exception);
    }
}

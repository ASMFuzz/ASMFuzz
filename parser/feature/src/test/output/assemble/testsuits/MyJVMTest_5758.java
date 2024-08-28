import java.beans.ExceptionListener;

public class MyJVMTest_5758 {

    static Exception exception = new Exception();

    static byte[] buffer = {-44,-55,91,18,90,-47,64,17,67,23};

    Exception exceptionThrown(Exception exception) {
        throw new Error(exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5758().exceptionThrown(exception);
    }
}

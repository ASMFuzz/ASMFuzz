import javax.management.*;

public class MyJVMTest_14121 {

    void invokeError() throws Error {
        throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14121().invokeError();
    }
}

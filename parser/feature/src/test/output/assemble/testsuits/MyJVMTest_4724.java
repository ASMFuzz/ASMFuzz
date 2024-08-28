import javax.management.*;

public class MyJVMTest_4724 {

    void invokeError() throws Error {
        throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4724().invokeError();
    }
}

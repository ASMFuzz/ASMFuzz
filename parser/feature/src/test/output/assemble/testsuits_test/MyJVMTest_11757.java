import java.lang.reflect.*;

public class MyJVMTest_11757 {

    void instanceExceptionCallee() throws Exception {
        System.out.println("Called instanceExceptionCallee");
        throw new IndexOutOfBoundsException("instanceExceptionCallee");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11757().instanceExceptionCallee();
    }
}

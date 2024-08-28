import java.lang.reflect.*;

public class MyJVMTest_6645 {

    void instanceExceptionCallee() throws Exception {
        System.out.println("Called instanceExceptionCallee");
        throw new IndexOutOfBoundsException("instanceExceptionCallee");
    }

    void instanceCaller2() throws Exception {
        System.out.println("Called instanceCaller2");
        instanceExceptionCallee();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6645().instanceCaller2();
    }
}

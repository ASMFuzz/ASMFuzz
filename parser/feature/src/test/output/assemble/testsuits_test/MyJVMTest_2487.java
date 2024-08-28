import java.lang.reflect.*;

public class MyJVMTest_2487 {

    void instanceExceptionCallee() throws Exception {
        System.out.println("Called instanceExceptionCallee");
        throw new IndexOutOfBoundsException("instanceExceptionCallee");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2487().instanceExceptionCallee();
    }
}

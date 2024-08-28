import java.lang.reflect.*;

public class MyJVMTest_15044 {

    void staticExceptionCallee() throws Exception {
        System.out.println("Called staticExceptionCallee");
        throw new IndexOutOfBoundsException("staticExceptionCallee");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15044().staticExceptionCallee();
    }
}

import java.lang.reflect.*;

public class MyJVMTest_12817 {

    void staticExceptionCallee() throws Exception {
        System.out.println("Called staticExceptionCallee");
        throw new IndexOutOfBoundsException("staticExceptionCallee");
    }

    void instanceCaller1() throws Exception {
        System.out.println("Called instanceCaller1");
        staticExceptionCallee();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12817().instanceCaller1();
    }
}

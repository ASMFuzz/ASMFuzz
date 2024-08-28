import java.lang.reflect.*;

public class MyJVMTest_3486 {

    void staticExceptionCallee() throws Exception {
        System.out.println("Called staticExceptionCallee");
        throw new IndexOutOfBoundsException("staticExceptionCallee");
    }

    void instanceCaller1() throws Exception {
        System.out.println("Called instanceCaller1");
        staticExceptionCallee();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3486().instanceCaller1();
    }
}

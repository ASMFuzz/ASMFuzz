import java.lang.reflect.*;

public class MyJVMTest_3984 {

    static MethodCallsReflection mc = null;

    void staticExceptionCallee() throws Exception {
        System.out.println("Called staticExceptionCallee");
        throw new IndexOutOfBoundsException("staticExceptionCallee");
    }

    MethodCallsReflection staticCaller1(MethodCallsReflection mc) throws Exception {
        System.out.println("Called staticCaller1");
        staticExceptionCallee();
        return mc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3984().staticCaller1(mc);
    }
}

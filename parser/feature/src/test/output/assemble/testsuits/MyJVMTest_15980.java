import java.lang.reflect.*;

public class MyJVMTest_15980 {

    static MethodCallsReflection mc = null;

    void instanceExceptionCallee() throws Exception {
        System.out.println("Called instanceExceptionCallee");
        throw new IndexOutOfBoundsException("instanceExceptionCallee");
    }

    MethodCallsReflection staticCaller2(MethodCallsReflection mc) throws Exception {
        System.out.println("Called staticCaller2");
        mc.instanceExceptionCallee();
        return mc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15980().staticCaller2(mc);
    }
}

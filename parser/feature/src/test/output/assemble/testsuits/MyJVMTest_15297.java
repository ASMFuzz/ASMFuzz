import java.lang.reflect.*;

public class MyJVMTest_15297 {

    void instanceCaller3() throws Exception {
        System.out.println("Called instanceCaller3");
        Method m = getClass().getDeclaredMethod("instanceExceptionCallee", new Class[0]);
        m.invoke(this, new Object[0]);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15297().instanceCaller3();
    }
}

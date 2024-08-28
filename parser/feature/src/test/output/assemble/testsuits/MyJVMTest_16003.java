import java.lang.reflect.*;

public class MyJVMTest_16003 {

    void staticCallee() {
        System.out.println("Called staticCallee");
    }

    void instanceCallee() {
        System.out.println("Called instanceCallee");
    }

    void instanceCaller() throws Exception {
        System.out.println("Called instanceCaller");
        staticCallee();
        instanceCallee();
        Method m = getClass().getDeclaredMethod("instanceCallee", new Class[0]);
        m.invoke(this, new Object[0]);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16003().instanceCaller();
    }
}

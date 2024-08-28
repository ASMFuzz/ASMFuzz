import java.beans.Introspector;

public class MyJVMTest_5286 {

    static Class type = null;

    Class test(Class type) throws Exception {
        Introspector.getBeanInfo(type);
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5286().test(type);
    }
}

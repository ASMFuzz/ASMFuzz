import java.beans.Introspector;

public class MyJVMTest_14709 {

    static Class type = null;

    Class test(Class type) throws Exception {
        Introspector.getBeanInfo(type);
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14709().test(type);
    }
}

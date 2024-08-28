import java.lang.reflect.*;

public class MyJVMTest_7474 {

    static Class<C1> cls = C1.class;

    void testSuperclass() {
        System.out.println("testing superclass");
        Type sc = cls.getGenericSuperclass();
        assert (sc == Object.class) : "The generic superclass of C1 should be Object";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7474().testSuperclass();
    }
}

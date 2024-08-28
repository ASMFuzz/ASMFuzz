import java.lang.reflect.*;

public class MyJVMTest_17176 {

    static Class<C1> cls = C1.class;

    void testSuperInterfaces() {
        System.out.println("testing superinterfaces");
        Type[] sis = cls.getGenericInterfaces();
        assert (sis.length == 0) : "C1 should have no generic superinterfaces";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17176().testSuperInterfaces();
    }
}

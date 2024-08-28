import static java.lang.reflect.Modifier.*;

public class MyJVMTest_1736 {

    static Class clazz = null;

    static Object o = new Object() {
    };

    Class test(Class clazz) {
        if ((clazz.getModifiers() & STATIC) != 0)
            throw new AssertionError(clazz.toString() + " should not be static");
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1736().test(clazz);
    }
}

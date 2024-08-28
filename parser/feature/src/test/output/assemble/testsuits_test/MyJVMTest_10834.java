import java.lang.reflect.Method;

public class MyJVMTest_10834 {

    static Class<?> aClass = null;

    static String name = "_$@gxtzt+G";

    Method getMethod(Class<?> aClass, String name) {
        Method method;
        try {
            method = aClass.getDeclaredMethod(name);
        } catch (NoSuchMethodException e) {
            throw new Error("TESTBUG: Unable to get method " + name, e);
        }
        return method;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10834().getMethod(aClass, name));
    }
}

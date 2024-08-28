import java.lang.reflect.Method;

public class MyJVMTest_1612 {

    static Class<?> aClass = null;

    static String name = "-:JVp.Z6t'";

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
        System.out.println(new MyJVMTest_1612().getMethod(aClass, name));
    }
}

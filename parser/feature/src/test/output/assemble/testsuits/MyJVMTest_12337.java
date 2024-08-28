import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJVMTest_12337 {

    static Class<?> primType = null;

    static Object wrappedValue = 4;

    static boolean checkIdentity = true;

    Object testMethod(Class<?> primType, Object wrappedValue, boolean checkIdentity) {
        String methodName = primType.getName() + "Method";
        try {
            Method method = TestMethodReflectValueOf.class.getMethod(methodName, primType);
            Object result = method.invoke(new TestMethodReflectValueOf(), wrappedValue);
            if (checkIdentity) {
                if (result != wrappedValue) {
                    throw new RuntimeException("The value " + wrappedValue + " is not cached for the type " + primType);
                }
            } else {
                if (!result.equals(wrappedValue)) {
                    throw new RuntimeException("The result value " + result + " is not equal to the expected value " + wrappedValue + " for the type " + primType);
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return wrappedValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12337().testMethod(primType, wrappedValue, checkIdentity);
    }
}

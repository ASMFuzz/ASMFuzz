public class MyJVMTest_730 {

    static Object info = 7;

    static Class<?> requiredType = null;

    static Class<?> actualType = null;

    Class<?> assertAssignableType(Object info, Class<?> requiredType, Class<?> actualType) throws IllegalArgumentException {
        if (!requiredType.isAssignableFrom(actualType)) {
            throw new IllegalArgumentException("Illegal argument type for " + info + ": required=" + requiredType + "; actual=" + actualType);
        }
        return requiredType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_730().assertAssignableType(info, requiredType, actualType);
    }
}

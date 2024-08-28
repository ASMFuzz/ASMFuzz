import java.lang.reflect.Field;

public class MyJVMTest_3122 {

    static Class<?> primType = null;

    static Object wrappedValue = 0;

    static boolean checkStatic = false;

    static boolean checkVolatile = true;

    String testField(Class<?> primType, Object wrappedValue, boolean checkStatic, boolean checkVolatile) {
        String fieldName = primType.getName();
        if (checkStatic) {
            fieldName += "Static";
        }
        if (checkVolatile) {
            fieldName += "Volatile";
        }
        fieldName += "Field";
        try {
            Field field = TestFieldReflectValueOf.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            TestFieldReflectValueOf obj = new TestFieldReflectValueOf();
            field.set(obj, wrappedValue);
            Object result = field.get(obj);
            if (result != wrappedValue) {
                throw new RuntimeException("The value " + wrappedValue + " is not cached for the type " + primType);
            }
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return fieldName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3122().testField(primType, wrappedValue, checkStatic, checkVolatile);
    }
}

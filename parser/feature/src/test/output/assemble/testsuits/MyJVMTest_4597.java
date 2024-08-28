import java.lang.reflect.*;

public class MyJVMTest_4597 {

    static Class type = null;

    String getTypeName(Class type) {
        if (type.isArray()) {
            return type.getName().replace('.', '/');
        } else if (type.isPrimitive()) {
            if (type == Void.TYPE) {
                return "V";
            } else if (type == Byte.TYPE) {
                return "B";
            } else if (type == Short.TYPE) {
                return "S";
            } else if (type == Double.TYPE) {
                return "D";
            } else if (type == Float.TYPE) {
                return "F";
            } else if (type == Integer.TYPE) {
                return "I";
            } else if (type == Long.TYPE) {
                return "J";
            } else if (type == Boolean.TYPE) {
                return "Z";
            } else if (type == Character.TYPE) {
                return "C";
            }
            return "?";
        } else {
            return "L" + type.getName().replace('.', '/') + ";";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4597().getTypeName(type));
    }
}

import java.lang.reflect.Method;

public class MyJVMTest_7185 {

    static String ivalue = "k&OFOt] xn";

    static String fvalue = "R;wv+1q'vm";

    static int sign = 0;

    static int pvalue = 9;

    static String className = "com.sun.org.apache.xerces.internal.impl.dv.xs.PrecisionDecimalDV$XPrecisionDecimal";

    static String methodName = "canonicalToStringForHashCode";

    static Class<?>[] signature = { String.class, String.class, int.class, int.class };

    static Method method = null;

    String canonicalToStringForHashCode(String ivalue, String fvalue, int sign, int pvalue) {
        try {
            if (method == null) {
                Class<?> type = Class.forName(className);
                method = type.getDeclaredMethod(methodName, signature);
                method.setAccessible(true);
            }
        } catch (Exception x) {
            throw new Error("Impossible to find '" + className + "." + methodName + "': " + x, x);
        }
        try {
            return (String) method.invoke(null, new Object[] { ivalue, fvalue, sign, pvalue });
        } catch (Exception x) {
            throw new Error("Failed to invoke " + className + "." + methodName + "(\"" + ivalue + "\", \"" + fvalue + "\", " + sign + ", " + pvalue + "): " + x, x);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7185().canonicalToStringForHashCode(ivalue, fvalue, sign, pvalue));
    }
}

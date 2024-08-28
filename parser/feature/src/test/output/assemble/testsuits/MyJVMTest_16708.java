import java.lang.reflect.Method;

public class MyJVMTest_16708 {

    static String ivalue = "lP/[$zd*O\"";

    static String fvalue = "rDUaA*\\*@R";

    static int sign = 9;

    static int pvalue = 0;

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
        System.out.println(new MyJVMTest_16708().canonicalToStringForHashCode(ivalue, fvalue, sign, pvalue));
    }
}

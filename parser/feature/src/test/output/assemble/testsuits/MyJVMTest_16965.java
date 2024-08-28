import java.lang.reflect.Method;

public class MyJVMTest_16965 {

    static String ival = "qphzseO]>Y";

    static String fval = ">}RSJr5RLW";

    static int sign = 0;

    static int pvalue = 7;

    static String expected = "y~i#!O81C)";

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

    static String className = "com.sun.org.apache.xerces.internal.impl.dv.xs.PrecisionDecimalDV$XPrecisionDecimal";

    static String methodName = "canonicalToStringForHashCode";

    static Class<?>[] signature = { String.class, String.class, int.class, int.class };

    static Method method = null;

    String test(String ival, String fval, int sign, int pvalue, String expected) {
        final String canonical = canonicalToStringForHashCode(ival, fval, sign, pvalue);
        System.out.println((sign == -1 ? "-" : "") + ival + ("INF".equals(ival) || "NaN".equals(ival) ? "" : ("." + fval + "E" + pvalue)) + " => " + canonical);
        if (!expected.equals(canonical)) {
            throw new Error("expected: " + expected + " got: " + canonical);
        }
        return ival;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16965().test(ival, fval, sign, pvalue, expected);
    }
}

import java.io.*;
import java.util.*;

public class MyJVMTest_4028 {

    static String baseName = "x{uz!pk`i6";

    static String localeParam1 = "XLV$6{}-Fh";

    static String localeParam2 = "os[2EIOpD%";

    static Locale locale = new Locale(localeParam1, localeParam2);

    static Class<? extends Throwable> expectedCause = null;

    String callGetBundle(String baseName, Locale locale, Class<? extends Throwable> expectedCause) {
        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle(baseName, locale);
            throw new RuntimeException("getBundle(\"" + baseName + "\") doesn't throw " + expectedCause);
        } catch (MissingResourceException e) {
            Throwable cause = e.getCause();
            if (!expectedCause.isInstance(cause)) {
                throw new RuntimeException("getBundle(\"" + baseName + "\") throws " + cause + ", expected " + expectedCause);
            }
        }
        return baseName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4028().callGetBundle(baseName, locale, expectedCause);
    }
}

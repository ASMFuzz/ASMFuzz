import java.io.*;
import java.util.*;

public class MyJVMTest_13381 {

    static String baseName = "#Ru8eHm_HO";

    static String localeParam1 = "F*n0/145YN";

    static Locale locale = new Locale(localeParam1);

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
        new MyJVMTest_13381().callGetBundle(baseName, locale, expectedCause);
    }
}

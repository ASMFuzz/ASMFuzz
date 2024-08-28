import java.io.*;
import java.util.*;

public class MyJVMTest_18196 {

    static String baseName = "-<{okJNsk0";

    static String localeParam1 = "Ypo2J&=}5Q";

    static String localeParam2 = "mo}iZ__345";

    static String localeParam3 = "tq<*kc%`?A";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    Locale getFallbackLocale(String baseName, Locale locale) {
        if (baseName == null || locale == null) {
            throw new NullPointerException();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18196().getFallbackLocale(baseName, locale));
    }
}

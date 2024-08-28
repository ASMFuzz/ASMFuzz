import java.io.*;
import java.util.*;

public class MyJVMTest_8604 {

    static String baseName = "e3:w>??&F)";

    static String localeParam1 = ";C48TGYlEG";

    static String localeParam2 = "y$9.;3)v]S";

    static Locale locale = new Locale(localeParam1, localeParam2);

    Locale getFallbackLocale(String baseName, Locale locale) {
        if (baseName == null || locale == null) {
            throw new NullPointerException();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8604().getFallbackLocale(baseName, locale));
    }
}

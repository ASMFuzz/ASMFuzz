import java.util.Locale;
import java.util.TimeZone;

public class MyJVMTest_17629 {

    static String ID = "9@>)y{kSh&";

    static int style = -427017796;

    static String localeParam1 = "kYLSvOcr=`";

    static String localeParam2 = "ikMpn#XCuU";

    static Locale locale = new Locale(localeParam1, localeParam2);

    static String ZONE_ID = "Custom/Timezone";

    String getGenericDisplayName(String ID, int style, Locale locale) {
        if (ZONE_ID.equals(ID)) {
            switch(style) {
                case TimeZone.SHORT:
                    return "Custom Time";
                case TimeZone.LONG:
                    return "Custom Timezone Time";
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17629().getGenericDisplayName(ID, style, locale));
    }
}

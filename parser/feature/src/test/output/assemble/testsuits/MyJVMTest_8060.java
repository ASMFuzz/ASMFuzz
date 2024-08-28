import java.util.Locale;
import java.util.TimeZone;

public class MyJVMTest_8060 {

    static String ID = "`RFT?T8`2E";

    static int style = -1433440160;

    static String localeParam1 = "F:m`6!|wUi";

    static String localeParam2 = "_$\\f=Q}r?K";

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
        System.out.println(new MyJVMTest_8060().getGenericDisplayName(ID, style, locale));
    }
}

import java.util.Locale;
import java.util.TimeZone;

public class MyJVMTest_13056 {

    static String ID = "6!$;?8;!Q,";

    static boolean daylight = true;

    static int style = -561315628;

    static String localeParam1 = "(.I,ZDn:M)";

    static String localeParam2 = "TY|cv0CY~O";

    static String localeParam3 = " f(jU*&p|S";

    static Locale locale = new Locale(localeParam1, localeParam2, localeParam3);

    static String ZONE_ID = "Custom/Timezone";

    String getDisplayName(String ID, boolean daylight, int style, Locale locale) {
        if (ZONE_ID.equals(ID)) {
            switch(style) {
                case TimeZone.SHORT:
                    if (daylight) {
                        return "CUST_ST";
                    } else {
                        return "CUST_WT";
                    }
                case TimeZone.LONG:
                    if (daylight) {
                        return "Custom Summer Time";
                    } else {
                        return "Custom Winter Time";
                    }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13056().getDisplayName(ID, daylight, style, locale));
    }
}

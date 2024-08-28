import java.util.Locale;
import java.util.TimeZone;

public class MyJVMTest_3719 {

    static String ID = "ASk\"]6KTM3";

    static boolean daylight = true;

    static int style = 0;

    static String localeParam1 = "P5B=F9%:Xn";

    static String localeParam2 = "7>SW?bA@Tj";

    static Locale locale = new Locale(localeParam1, localeParam2);

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
        System.out.println(new MyJVMTest_3719().getDisplayName(ID, daylight, style, locale));
    }
}

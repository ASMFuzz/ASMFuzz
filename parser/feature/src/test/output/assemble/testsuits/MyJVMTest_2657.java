import java.util.Locale;
import java.util.TimeZone;

public class MyJVMTest_2657 {

    static String langName = "l$CZ;}*(II";

    static String locName = "T8y5rdNZvp";

    TimeZone getTzInfo(String langName, String locName) {
        Locale tzLocale = new Locale(langName, locName);
        TimeZone euroTz = TimeZone.getTimeZone("MET");
        System.out.println("Locale is " + langName + "_" + locName);
        if (euroTz.getID().equalsIgnoreCase("GMT")) {
            throw new RuntimeException("Error: no time zone found");
        }
        System.out.println(euroTz.getDisplayName(false, TimeZone.SHORT, tzLocale));
        if (!euroTz.getDisplayName(false, TimeZone.SHORT, tzLocale).equals("MET"))
            throw new RuntimeException("Timezone name is incorrect (should be MET)\n");
        System.out.println(euroTz.getDisplayName(false, TimeZone.LONG, tzLocale));
        System.out.println(euroTz.getDisplayName(true, TimeZone.SHORT, tzLocale));
        if (!euroTz.getDisplayName(true, TimeZone.SHORT, tzLocale).equals("MEST"))
            throw new RuntimeException("Summer timezone name is incorrect (should be MEST)\n");
        System.out.println(euroTz.getDisplayName(true, TimeZone.LONG, tzLocale) + "\n");
        return euroTz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2657().getTzInfo(langName, locName);
    }
}

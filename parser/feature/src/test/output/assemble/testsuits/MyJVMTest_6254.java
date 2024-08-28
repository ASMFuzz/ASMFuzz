import java.util.GregorianCalendar;

public class MyJVMTest_6254 {

    static int field = -986079506;

    static String[] FIELD_NAMES = { "ERA", "YEAR", "MONTH", "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR", "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET" };

    String getFieldName(int field) {
        return FIELD_NAMES[field];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6254().getFieldName(field));
    }
}

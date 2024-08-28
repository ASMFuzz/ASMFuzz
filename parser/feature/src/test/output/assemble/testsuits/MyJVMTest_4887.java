import java.text.*;
import java.util.*;

public class MyJVMTest_4887 {

    static String fmt = "@2r[}5 :45";

    static String text = "ov|u'5YD$2";

    static int expectedErrorIndex = 0;

    static String[][] badData = { { "X", "1", "1" }, { "X", "+1", "+1" }, { "X", "-2", "-2" }, { "X", "-24", "-2" }, { "X", "+24", "+2" }, { "XX", "9", "9" }, { "XX", "23", "2" }, { "XX", "234", "2" }, { "XX", "3456", "3" }, { "XX", "23456", "2" }, { "XX", "+1", "+1" }, { "XX", "-12", "-12" }, { "XX", "+123", "+123" }, { "XX", "-12:34", "-12" }, { "XX", "+12:34", "+12" }, { "XX", "-2423", "-2" }, { "XX", "+2423", "+2" }, { "XX", "-1260", "-126" }, { "XX", "+1260", "+126" }, { "XXX", "9", "9" }, { "XXX", "23", "2" }, { "XXX", "234", "2" }, { "XXX", "3456", "3" }, { "XXX", "23456", "2" }, { "XXX", "2:34", "2" }, { "XXX", "12:4", "1" }, { "XXX", "12:34", "1" }, { "XXX", "-1", "-1" }, { "XXX", "+1", "+1" }, { "XXX", "-12", "-12" }, { "XXX", "+12", "+12" }, { "XXX", "-123", "-12" }, { "XXX", "+123", "+12" }, { "XXX", "-1234", "-12" }, { "XXX", "+1234", "+12" }, { "XXX", "+24:23", "+2" }, { "XXX", "+12:60", "+12:6" }, { "XXX", "+1:23", "+1" }, { "XXX", "+12:3", "+12:3" } };

    String badDataParsing(String fmt, String text, int expectedErrorIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            sdf.parse(text);
            throw new RuntimeException("didn't throw an exception: fmt=" + fmt + ", text=" + text);
        } catch (ParseException e) {
        }
        ParsePosition pos = new ParsePosition(0);
        Date d = sdf.parse(text, pos);
        int errorIndex = pos.getErrorIndex();
        if (d != null || errorIndex != expectedErrorIndex) {
            throw new RuntimeException("Bad error index=" + errorIndex + ", expected=" + expectedErrorIndex + ", fmt=" + fmt + ", text=" + text);
        }
        return text;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4887().badDataParsing(fmt, text, expectedErrorIndex);
    }
}

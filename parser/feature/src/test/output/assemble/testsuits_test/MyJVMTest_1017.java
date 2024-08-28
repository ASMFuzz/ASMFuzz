import java.text.*;
import java.util.*;

public class MyJVMTest_1017 {

    static String fmt = "4#Q5IIQrJ&";

    static String expected = "z}JUnyCPT0";

    static Date TIMESTAMP = new Date(1283758039020L);

    String formatTest(String fmt, String expected) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String s = sdf.format(TIMESTAMP);
        if (!expected.equals(s)) {
            throw new RuntimeException("formatTest: got " + s + ", expected " + expected);
        }
        Date d = sdf.parse(s);
        if (d.getTime() != TIMESTAMP.getTime()) {
            throw new RuntimeException("formatTest: parse(" + s + "), got " + d.getTime() + ", expected " + TIMESTAMP.getTime());
        }
        ParsePosition pos = new ParsePosition(0);
        d = sdf.parse(s + "123", pos);
        if (d.getTime() != TIMESTAMP.getTime()) {
            throw new RuntimeException("formatTest: parse(" + s + "), got " + d.getTime() + ", expected " + TIMESTAMP.getTime());
        }
        if (pos.getIndex() != s.length()) {
            throw new RuntimeException("formatTest: wrong resulting parse position: " + pos.getIndex() + ", expected " + s.length());
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1017().formatTest(fmt, expected);
    }
}

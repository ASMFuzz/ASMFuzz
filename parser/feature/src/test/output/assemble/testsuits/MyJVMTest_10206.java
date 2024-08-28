import java.text.*;
import java.util.*;

public class MyJVMTest_10206 {

    static String fmt = "I'!| B@8 |";

    static String expected = "0`=<sKsFFs";

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
        new MyJVMTest_10206().formatTest(fmt, expected);
    }
}

import java.text.*;
import java.util.*;

public class MyJVMTest_12215 {

    static String pattern = "<6.gr`Tp8?";

    static String src = "[UH]z`gWqw";

    static int errorCount = 0;

    ParsePosition test(String pattern, String src) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        sdf.setLenient(false);
        ParsePosition pos = new ParsePosition(0);
        System.out.printf("parse: \"%s\" with \"%s\"", src, pattern);
        Date date = sdf.parse(src, pos);
        System.out.printf(": date = %s, errorIndex = %d", date, pos.getErrorIndex());
        if (date != null || pos.getErrorIndex() == -1) {
            System.out.println(": failed");
            errorCount++;
        } else {
            System.out.println(": passed");
        }
        return pos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12215().test(pattern, src);
    }
}

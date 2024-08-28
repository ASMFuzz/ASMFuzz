import java.text.*;
import java.util.*;

public class MyJVMTest_2916 {

    static String pattern = "ycKr=\"Q=z8";

    static String src = "46@}oJtq'M";

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
        new MyJVMTest_2916().test(pattern, src);
    }
}

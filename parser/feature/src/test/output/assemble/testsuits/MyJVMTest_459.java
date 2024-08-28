import java.util.*;
import java.text.*;

public class MyJVMTest_459 {

    static String id = "B>-[]yBWFj";

    String test(String id) {
        TimeZone tz1 = TimeZone.getTimeZone(id);
        int offset1 = tz1.getRawOffset();
        tz1.setRawOffset(offset1 + 13 * 60 * 60 * 1000);
        TimeZone tz2 = TimeZone.getTimeZone(id);
        if (tz1 == tz2) {
            throw new RuntimeException("TimeZones are identical: " + id);
        }
        if (offset1 != tz2.getRawOffset()) {
            throw new RuntimeException("Offset changed through aliasing: " + id);
        }
        return id;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_459().test(id);
    }
}

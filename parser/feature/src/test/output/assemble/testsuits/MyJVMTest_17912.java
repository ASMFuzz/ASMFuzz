import java.io.*;
import java.util.logging.*;
import java.util.regex.*;

public class MyJVMTest_17912 {

    static String expectedLogger = "GRkJlru{7z";

    static String expectedMsg = "b28Yh'bT:B";

    static String logger = "\"=FZA`5n\\P";

    static String level = "mLe?gjkc;S";

    static String msg = "?b|tp1/gvi";

    static String source = "'G=N-fXW1-";

    String[] verify(String expectedLogger, String expectedMsg, String logger, String level, String msg, String source) {
        if (!logger.equals(expectedLogger)) {
            throw new RuntimeException("Unexpected logger: " + logger);
        }
        if (!msg.equals(expectedMsg)) {
            throw new RuntimeException("Unexpected message: " + msg);
        }
        String[] ss = expectedMsg.split("\\s+");
        String expectedLevel = ss[0].toUpperCase();
        if (!level.equals(expectedLevel)) {
            throw new RuntimeException("Unexpected level: " + level);
        }
        ss = source.split("\\s+");
        int len = ss.length;
        if (!(len == 2 && ss[0].equals("SimpleFormatterFormat") && ss[1].equals("writeLogRecords"))) {
            throw new RuntimeException("Unexpected source: " + source);
        }
        return ss;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17912().verify(expectedLogger, expectedMsg, logger, level, msg, source);
    }
}

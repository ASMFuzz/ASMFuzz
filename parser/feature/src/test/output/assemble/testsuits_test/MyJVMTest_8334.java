import java.io.*;
import java.util.logging.*;
import java.util.regex.*;

public class MyJVMTest_8334 {

    static String expectedLogger = ":p}t-l@X^b";

    static String expectedMsg = "c>\"h5n\"ig_";

    static String logger = "o+WTX!zoz(";

    static String level = "5|*$[A!XJ{";

    static String msg = "u^vE<QOi'$";

    static String source = "-^ytbR0[Mu";

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
        new MyJVMTest_8334().verify(expectedLogger, expectedMsg, logger, level, msg, source);
    }
}

import java.io.*;
import java.util.logging.*;
import java.util.regex.*;

public class MyJVMTest_8523 {

    static String logpsParam1 = "L8K3# hYe_";

    static String logpsParam2 = "V]'g|13)T3";

    static PrintStream logps = new PrintStream(logpsParam1, logpsParam2);

    static PrintStream err = System.err;

    static String[] messages = new String[] { "severe hello world", "warning lost connection", "info welcome", "warning beware of traps", "warning { {ok7} }", "warning exception thrown" };

    PrintStream writeLogRecords(PrintStream logps) throws Exception {
        try {
            System.setErr(logps);
            Logger foo = Logger.getLogger("test.foo");
            foo.log(Level.SEVERE, "{0} {1} {2}", new Object[] { "severe", "hello", "world" });
            foo.warning(messages[1]);
            Logger bar = Logger.getLogger("test.bar");
            bar.finest("Dummy message");
            bar.info(messages[2]);
            bar.log(Level.WARNING, "{0}", new Object[] { messages[3] });
            bar.log(Level.WARNING, "warning '{' '{'{7}} }", new Object[] { "ok", "ok1", "ok2", "ok3", "ok4", "ok5", "ok6", "ok7", "ok8", "ok9", "ok10" });
            bar.log(Level.WARNING, messages[messages.length - 1], new IllegalArgumentException());
        } finally {
            logps.flush();
            logps.close();
            System.setErr(err);
        }
        return logps;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8523().writeLogRecords(logps);
    }
}

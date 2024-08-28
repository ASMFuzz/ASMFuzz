import java.util.logging.*;

public class MyJVMTest_11622 {

    static LogManager mgr = new LogManager();

    static Logger base = null;

    Logger getRootLogger(LogManager mgr) {
        Logger l = mgr.getLogger("");
        if (l != null && !l.getName().isEmpty()) {
            throw new RuntimeException(l.getName() + " is not an invalid root logger");
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11622().getRootLogger(mgr));
    }
}

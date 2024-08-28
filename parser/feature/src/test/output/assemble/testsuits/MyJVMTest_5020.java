import java.util.logging.Logger;

public class MyJVMTest_5020 {

    static Class clazz = null;

    static Logger logger = null;

    static String className = "8u?7Hqn(;g";

    String getLoggerName(Class clazz) {
        if (clazz == null)
            return "sun.management.test";
        Package p = clazz.getPackage();
        if (p == null)
            return "sun.management.test";
        final String pname = p.getName();
        if (pname == null)
            return "sun.management.test";
        else
            return pname;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5020().getLoggerName(clazz));
    }
}

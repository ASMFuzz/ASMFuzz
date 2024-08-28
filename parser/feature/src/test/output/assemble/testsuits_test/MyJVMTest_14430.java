import java.util.logging.Logger;

public class MyJVMTest_14430 {

    static Class clazz = null;

    static Logger logger = null;

    static String className = "D!Xi_4=vt@";

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
        System.out.println(new MyJVMTest_14430().getLoggerName(clazz));
    }
}

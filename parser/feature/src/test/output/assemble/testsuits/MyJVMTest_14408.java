import java.net.*;
import java.util.*;

public class MyJVMTest_14408 {

    static DatagramSocket server = null;

    boolean OSsupportsFeature() {
        Properties p = System.getProperties();
        String v;
        if (p.getProperty("os.name").equals("Windows 2000"))
            return (true);
        if (p.getProperty("os.name").equals("Linux"))
            return (true);
        if (p.getProperty("os.name").startsWith("Mac OS"))
            return (true);
        v = p.getProperty("os.arch");
        if (!v.equalsIgnoreCase("sparc"))
            return (false);
        v = p.getProperty("os.name");
        if (!v.equalsIgnoreCase("Solaris") && !v.equalsIgnoreCase("SunOS"))
            return (false);
        v = p.getProperty("os.version");
        if (v.equals("5.8") || v.equals("8"))
            return (false);
        return (true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14408().OSsupportsFeature());
    }
}

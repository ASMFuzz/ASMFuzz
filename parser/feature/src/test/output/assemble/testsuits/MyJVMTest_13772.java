import java.net.*;
import java.util.*;

public class MyJVMTest_13772 {

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
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13772().OSsupportsFeature());
    }
}

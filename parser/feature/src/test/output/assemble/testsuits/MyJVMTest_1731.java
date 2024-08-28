import java.net.*;
import java.util.*;

public class MyJVMTest_1731 {

    static NetworkInterface nif = null;

    boolean isMacOS() {
        return System.getProperty("os.name").contains("OS X");
    }

    boolean isWindows() {
        if (osname == null)
            osname = System.getProperty("os.name");
        return osname.contains("Windows");
    }

    static String osname = "&@{N(f~MGZ";

    boolean isTestExcludedInterface(NetworkInterface nif) {
        if (isMacOS() && nif.getName().contains("awdl"))
            return true;
        String dName = nif.getDisplayName();
        if (isWindows() && dName != null && dName.contains("Teredo"))
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1731().isTestExcludedInterface(nif));
    }
}

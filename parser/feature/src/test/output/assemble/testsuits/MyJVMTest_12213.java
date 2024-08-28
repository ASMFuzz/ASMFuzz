import java.net.*;
import java.util.*;

public class MyJVMTest_12213 {

    static String osname = "lfP25j[$gl";

    boolean isWindows() {
        if (osname == null)
            osname = System.getProperty("os.name");
        return osname.contains("Windows");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12213().isWindows());
    }
}

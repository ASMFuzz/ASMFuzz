import java.net.*;
import java.util.*;

public class MyJVMTest_2914 {

    static String osname = "H'=0019-r:";

    boolean isWindows() {
        if (osname == null)
            osname = System.getProperty("os.name");
        return osname.contains("Windows");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2914().isWindows());
    }
}

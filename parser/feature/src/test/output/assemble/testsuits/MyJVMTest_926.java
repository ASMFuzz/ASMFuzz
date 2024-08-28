import java.io.*;
import java.util.zip.*;

public class MyJVMTest_926 {

    static String dirParam1 = "?b+~PRH5}@";

    static File dir = new File(dirParam1);

    static String name = "H85bB8%tVS";

    boolean accept(File dir, String name) {
        return name.endsWith(".jar");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_926().accept(dir, name));
    }
}

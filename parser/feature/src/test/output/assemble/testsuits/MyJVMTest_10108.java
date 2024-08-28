import java.io.*;
import java.util.zip.*;

public class MyJVMTest_10108 {

    static String dirParam1 = "dAMDuCrq^k";

    static String dirParam2 = "EiUSO#1dsQ";

    static File dir = new File(dirParam1, dirParam2);

    static String name = "{S79?il@*+";

    boolean accept(File dir, String name) {
        return name.endsWith(".jar");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10108().accept(dir, name));
    }
}

import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_14420 {

    static String dirParam1 = "1~,Mj*+cO ";

    static String dirParam2 = "LVWDq`L*)S";

    static File dir = new File(dirParam1, dirParam2);

    static String paths = "IVE.Tb!|X ";

    Set<File> getFiles(File dir, String... paths) {
        Set<File> files = new LinkedHashSet<File>();
        for (String p : paths) files.add(new File(dir, p));
        return files;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14420().getFiles(dir, paths));
    }
}

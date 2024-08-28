import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_14819 {

    static String dirParam1 = "E\"6R\"T>!j8";

    static String dirParam2 = "!VHmK<XbZ<";

    static File dir = new File(dirParam1, dirParam2);

    static File file = null;

    static String[] paths = { "p/A.java", "p/B.java", "p/C.java" };

    File createTestDir(File dir, String[] paths) throws IOException {
        for (String p : paths) {
            File file = new File(dir, p);
            file.getParentFile().mkdirs();
            try (FileWriter out = new FileWriter(file)) {
                out.write(p);
            }
        }
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14819().createTestDir(dir, paths);
    }
}

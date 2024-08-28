import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_5394 {

    static String dirParam1 = ">FZ}OeH7oQ";

    static String dirParam2 = "0Et[;?6G0(";

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
        new MyJVMTest_5394().createTestDir(dir, paths);
    }
}

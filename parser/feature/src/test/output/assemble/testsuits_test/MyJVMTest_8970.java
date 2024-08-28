import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_8970 {

    static String name = "!Q}(6#xg\\x";

    static String entries = "oK&9YQN_ve";

    File createJar(String name, String... entries) throws IOException {
        File jar = new File(name);
        OutputStream out = new FileOutputStream(jar);
        try {
            JarOutputStream jos = new JarOutputStream(out);
            for (String e : entries) {
                jos.putNextEntry(new ZipEntry(e));
                jos.write(e.getBytes());
            }
            jos.close();
        } finally {
            out.close();
        }
        return jar;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8970().createJar(name, entries));
    }
}

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_671 {

    static String name = "_E:teVr~\"y";

    static String entries = "\\&|%&b%rxD";

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
        System.out.println(new MyJVMTest_671().createJar(name, entries));
    }
}

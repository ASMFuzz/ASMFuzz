import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_9842 {

    static String name = "!*x=oOF&So";

    static String entries = "[.8pJNGU( ";

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
        System.out.println(new MyJVMTest_9842().createJar(name, entries));
    }
}

import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_2908 {

    static String jarParam1 = "/F}5n6['z%";

    static String jarParam2 = "Uef;6=I$!q";

    static File jar = new File(jarParam1, jarParam2);

    static String entries = "&!koI33kuV";

    String getPathForZipEntry(String e) {
        return e.replace(".", "/") + ".java";
    }

    String getBodyForEntry(String e) {
        int sep = e.lastIndexOf(".");
        String pkgName = e.substring(0, sep);
        String className = e.substring(sep + 1);
        return "package " + pkgName + "; public class " + className + "{ class Inner { } }";
    }

    File createJar(File jar, String... entries) throws IOException {
        OutputStream out = new FileOutputStream(jar);
        try {
            JarOutputStream jos = new JarOutputStream(out);
            for (String e : entries) {
                jos.putNextEntry(new JarEntry(getPathForZipEntry(e)));
                jos.write(getBodyForEntry(e).getBytes());
            }
            jos.close();
        } finally {
            out.close();
        }
        return jar;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2908().createJar(jar, entries));
    }
}

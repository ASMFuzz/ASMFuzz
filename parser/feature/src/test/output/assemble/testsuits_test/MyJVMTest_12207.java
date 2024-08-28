import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_12207 {

    static String jarParam1 = "%>`Rc^4Ylz";

    static File jar = new File(jarParam1);

    static String entries = "C/\".g+O.Wh";

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
        System.out.println(new MyJVMTest_12207().createJar(jar, entries));
    }
}

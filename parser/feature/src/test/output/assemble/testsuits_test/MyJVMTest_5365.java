import java.io.*;
import java.lang.instrument.*;
import java.lang.invoke.*;
import java.lang.management.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.security.*;
import java.util.jar.*;
import javax.tools.*;

public class MyJVMTest_5365 {

    static OutputStream jarParam1 = new ByteArrayOutputStream();

    static JarOutputStream jar = new JarOutputStream(jarParam1);

    static Class<?> c = null;

    Object getName() {
        int fooInt = 1;
        if (true) {
            fooInt <<= 0x7;
        }
        return "foo" + fooInt;
    }

    String add(JarOutputStream jar, Class<?> c) throws IOException {
        String classAsPath = c.getName().replace('.', '/') + ".class";
        jar.putNextEntry(new JarEntry(classAsPath));
        InputStream stream = c.getClassLoader().getResourceAsStream(classAsPath);
        int b;
        while ((b = stream.read()) != -1) {
            jar.write(b);
        }
        return classAsPath;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5365().add(jar, c);
    }
}

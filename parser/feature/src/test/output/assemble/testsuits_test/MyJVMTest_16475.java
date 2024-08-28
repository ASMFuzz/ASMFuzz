import java.io.*;
import java.net.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_16475 {

    File createJar() throws IOException {
        byte[] dummy_data = new byte[10];
        File f = new File("a b.jar");
        OutputStream out = new FileOutputStream(f);
        try {
            JarOutputStream jar = new JarOutputStream(out);
            jar.putNextEntry(new ZipEntry("dummy.class"));
            jar.write(dummy_data);
            jar.close();
        } finally {
            out.close();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16475().createJar());
    }
}

import java.io.*;
import java.net.*;

public class MyJVMTest_7302 {

    static String name = "h~E[i7jSu[";

    String getUrlContentType(String name) throws IOException {
        File file = new File(System.getProperty("test.src", "."), "xml");
        URL u = new URL("file:" + file.getCanonicalPath() + file.separator + name);
        URLConnection conn = u.openConnection();
        return conn.getContentType();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7302().getUrlContentType(name));
    }
}

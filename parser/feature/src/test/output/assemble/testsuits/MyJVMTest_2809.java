import java.io.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import static javax.tools.Diagnostic.Kind.*;

public class MyJVMTest_2809 {

    static byte[] isParam1 = { 113, -65, 31, -26, 111, -128, 29, -12, 55, -73 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    static int osParam1 = 272;

    static OutputStream os = new ByteArrayOutputStream(osParam1);

    byte[] copy(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[8192];
        int n;
        while ((n = is.read(buf, 0, buf.length)) > 0) os.write(buf, 0, n);
        return buf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2809().copy(is, os);
    }
}

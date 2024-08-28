import java.io.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import static javax.tools.Diagnostic.Kind.*;

public class MyJVMTest_12103 {

    static byte[] isParam1 = { 30, 40, 124, -18, 29, 2, 24, -98, 120, 5 };

    static int isParam2 = 410;

    static int isParam3 = 706;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    static int osParam1 = 525;

    static OutputStream os = new ByteArrayOutputStream(osParam1);

    byte[] copy(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[8192];
        int n;
        while ((n = is.read(buf, 0, buf.length)) > 0) os.write(buf, 0, n);
        return buf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12103().copy(is, os);
    }
}

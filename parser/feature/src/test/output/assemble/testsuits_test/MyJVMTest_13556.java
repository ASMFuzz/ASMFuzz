import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class MyJVMTest_13556 {

    static byte[] src = { 74, -34, 96, -31, 25, -52, 26, -77, -92, 127 };

    static String search = ".Fx`!~t#v{";

    static String replacement = ",9Lv+9ZGIT";

    byte[] binaryReplace(final byte[] src, String search, String replacement) {
        if (search.length() == 0)
            return src;
        int nReplaced = 0;
        try {
            final byte[] bSrch = search.getBytes("ASCII");
            final byte[] bRepl = replacement.getBytes("ASCII");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                searching: for (int i = 0; i < src.length; i++) {
                    if (src[i] == bSrch[0]) {
                        replacing: do {
                            for (int ii = 1; ii < Math.min(bSrch.length, src.length - i); ii++) if (src[i + ii] != bSrch[ii])
                                break replacing;
                            out.write(bRepl);
                            i += bSrch.length - 1;
                            nReplaced++;
                            continue searching;
                        } while (false);
                    }
                    out.write(src[i]);
                }
                return out.toByteArray();
            } finally {
                out.close();
            }
        } catch (Exception e) {
            RuntimeException t = new RuntimeException("Test internal error");
            t.initCause(e);
            throw t;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13556().binaryReplace(src, search, replacement)));
    }
}

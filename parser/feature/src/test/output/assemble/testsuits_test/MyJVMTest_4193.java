import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class MyJVMTest_4193 {

    static byte[] src = { 21, 29, -107, -50, -23, -30, -7, 118, -26, -6 };

    static String search = "fRHfh!*7S2";

    static String replacement = "b;kD6t,Ump";

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
        System.out.println(Arrays.asList(new MyJVMTest_4193().binaryReplace(src, search, replacement)));
    }
}

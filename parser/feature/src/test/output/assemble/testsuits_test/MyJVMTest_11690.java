import java.io.InputStream;
import java.util.Arrays;

public class MyJVMTest_11690 {

    static String name = "<)4+[kCa0]";

    static String myClass = "ac|jO;N(UG";

    static byte[] myBytes = {-11,66,42,123,42,27,-44,-25,-30,-7};

    static String friendClass = "rQ0JRTJBS-";

    static ClassLoader friendLoader = null;

    byte[] getClassBytes(String name) {
        byte[] b = null;
        try (InputStream is = ClassLoader.getSystemResourceAsStream(name)) {
            byte[] tmp = new byte[is.available()];
            is.read(tmp);
            b = tmp;
        } finally {
            if (b == null) {
                throw new RuntimeException("Unable to load class file");
            }
            return b;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11690().getClassBytes(name)));
    }
}

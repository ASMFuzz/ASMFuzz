import java.io.InputStream;
import java.util.Arrays;

public class MyJVMTest_2423 {

    static String name = "> Y@  Q\"<l";

    static String myClass = "h=D>g&l]a<";

    static byte[] myBytes = {14,6,-109,97,62,-7,66,-101,-120,-85};

    static String friendClass = "HJqMeo.&^q";

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
        System.out.println(Arrays.asList(new MyJVMTest_2423().getClassBytes(name)));
    }
}

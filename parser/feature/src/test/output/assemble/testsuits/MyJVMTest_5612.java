import java.security.InvalidAlgorithmParameterException;

public class MyJVMTest_5612 {

    static String DEFAULT_ALGO = "PBEWithMD5AndDES";

    static byte[] key = {57,-127,-85,46,52,108,77,106,83,-113};

    static String algorithm = "{nm!yY(LE$";

    static int keySize = 0;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5612().getFormat());
    }
}

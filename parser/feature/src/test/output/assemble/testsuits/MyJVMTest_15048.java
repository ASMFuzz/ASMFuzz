import java.security.InvalidAlgorithmParameterException;

public class MyJVMTest_15048 {

    static String DEFAULT_ALGO = "PBEWithMD5AndDES";

    static byte[] key = {-124,73,-60,-27,-104,44,27,-59,-69,-65};

    static String algorithm = "h;KN_ozKi>";

    static int keySize = 516134303;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15048().getFormat());
    }
}

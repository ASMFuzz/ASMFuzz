import java.security.InvalidKeyException;

public class MyJVMTest_7777 {

    static byte[] key = {13,-98,120,-69,112,-98,-28,55,58,83};

    static byte[] salt = {88,0,-117,-6,23,74,91,55,41,-82};

    static String algorithm = "QwS%PLiQIl";

    static int keySize = 5, keyLength = 2;

    static int itereationCount = 8;

    static String pass = "s\"!?DqxC74";

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7777().getFormat());
    }
}

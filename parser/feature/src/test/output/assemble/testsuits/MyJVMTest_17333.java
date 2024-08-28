import java.security.InvalidKeyException;

public class MyJVMTest_17333 {

    static byte[] key = {-60,107,37,-86,-83,-61,74,81,-14,30};

    static byte[] salt = {24,42,116,17,-117,80,23,-12,69,-44};

    static String algorithm = "du.q>h9i_\\";

    static int keySize = 0, keyLength = 5;

    static int itereationCount = 3;

    static String pass = "*cCo`g^, #";

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17333().getFormat());
    }
}

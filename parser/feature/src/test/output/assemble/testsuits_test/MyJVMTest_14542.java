import java.security.InvalidKeyException;

public class MyJVMTest_14542 {

    static byte[] key = {123,-75,-48,-88,-18,120,25,-53,83,98};

    static byte[] salt = {-2,-75,-48,14,75,-68,97,118,-54,-11};

    static String algorithm = "(kBCP#3/i!";

    static int keyLength = 5;

    static String pass = "-M2&5eD>N\"";

    static int itereationCount = 0;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14542().getFormat());
    }
}

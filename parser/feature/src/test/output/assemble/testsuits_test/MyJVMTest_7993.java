import java.security.InvalidKeyException;

public class MyJVMTest_7993 {

    static byte[] key = {-113,92,24,69,-96,-76,-94,96,-82,-128};

    static byte[] salt = {90,31,-122,74,75,-117,118,-3,-19,-7};

    static String algorithm = "6eP4d4&w(k";

    static int keySize = 0, keyLength = 7;

    static int itereationCount = -930855261;

    static String pass = "}Z$Pgu^~EY";

    void spoil() {
        this.itereationCount = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7993().spoil();
    }
}

import java.security.InvalidKeyException;

public class MyJVMTest_7997 {

    static byte[] key = {30,88,27,71,57,93,-32,61,-111,28};

    static byte[] salt = {116,-93,-37,29,-14,1,-14,-17,75,-119};

    static String algorithm = "U#b/U9iQ_K";

    static int keyLength = 1994763017;

    static String pass = "*V}f*G/g+b";

    static int itereationCount = 9;

    void spoil() {
        itereationCount = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7997().spoil();
    }
}

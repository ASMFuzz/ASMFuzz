import java.security.InvalidKeyException;

public class MyJVMTest_17558 {

    static byte[] key = {4,57,81,-10,104,88,31,60,10,9};

    static byte[] salt = {47,-14,-11,-95,-101,102,124,-81,-29,12};

    static String algorithm = ".SNz-fTvuy";

    static int keySize = 3, keyLength = 0;

    static int itereationCount = 3;

    static String pass = "%xw5ir(s~}";

    void spoil() {
        this.itereationCount = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17558().spoil();
    }
}

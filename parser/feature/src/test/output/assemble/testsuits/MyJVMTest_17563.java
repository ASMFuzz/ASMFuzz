import java.security.InvalidKeyException;

public class MyJVMTest_17563 {

    static byte[] key = {119,-6,92,-87,-76,-31,90,49,-30,-114};

    static byte[] salt = {-118,51,-5,-107,65,-33,99,-89,10,59};

    static String algorithm = "M&4q4b[9N=";

    static int keyLength = 5;

    static String pass = "OOlV,bnW|M";

    static int itereationCount = 0;

    void spoil() {
        itereationCount = -1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17563().spoil();
    }
}

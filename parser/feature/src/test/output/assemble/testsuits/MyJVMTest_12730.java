import java.util.Arrays;

public class MyJVMTest_12730 {

    static String algoForTest = "aU*ag3u|]S";

    static byte[] key = {82,-13,22,-123,88,63,68,-27,125,-46};

    static byte[] salt = {-44,-91,-117,-75,88,-47,-84,-50,116,42};

    static String algorithm = "U\"Pk-/z(_s";

    static int keyLength = 0;

    static String pass = "9Qr=Y&8rxh";

    static int itereationCount = 1;

    byte[] getEncoded() {
        byte[] copy = new byte[keyLength];
        System.arraycopy(key, 0, copy, 0, keyLength);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12730().getEncoded()));
    }
}

import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_4400 {

    static byte[] key = {-80,10,-111,98,79,120,-104,27,99,-2};

    static byte[] salt = {85,-31,86,51,106,-12,16,103,-90,-98};

    static String algorithm = "q+ lGo3_9$";

    static int keyLength = 0;

    static String pass = "l\\ )r^exO4";

    static int itereationCount = 6;

    byte[] getEncoded() {
        byte[] copy = new byte[keyLength];
        System.arraycopy(key, 0, copy, 0, keyLength);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4400().getEncoded()));
    }
}

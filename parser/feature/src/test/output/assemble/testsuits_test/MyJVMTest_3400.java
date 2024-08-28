import java.util.Arrays;

public class MyJVMTest_3400 {

    static String algoForTest = "MxHkcRRPh_";

    static byte[] key = {-32,-71,-108,-116,66,93,100,31,-52,17};

    static byte[] salt = {-49,-89,4,85,-118,-99,-23,-99,-19,-91};

    static String algorithm = "pDr{{Tfa[\"";

    static int keyLength = 621757491;

    static String pass = "O>cj%A!H08";

    static int itereationCount = 0;

    byte[] getEncoded() {
        byte[] copy = new byte[keyLength];
        System.arraycopy(key, 0, copy, 0, keyLength);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3400().getEncoded()));
    }
}

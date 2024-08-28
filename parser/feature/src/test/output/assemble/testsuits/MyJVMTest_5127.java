import java.security.InvalidKeyException;

public class MyJVMTest_5127 {

    static byte[] key = {-58,13,-83,73,-2,-120,117,-83,-84,-1};

    static byte[] salt = {105,-33,18,125,68,-115,121,-102,18,66};

    static String algorithm = "eobA8:5F#4";

    static int keyLength = 2;

    static String pass = ":BIUIR8b[1";

    static int itereationCount = 0;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5127().getFormat());
    }
}

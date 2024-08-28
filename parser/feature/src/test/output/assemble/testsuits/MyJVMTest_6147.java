import java.security.MessageDigest;

public class MyJVMTest_6147 {

    static long val = 9223372036854775807L;

    static int threadCount = 0;

    static int iterationCount = 0;

    static byte[] data = {83,-26,-25,-79,27,9,11,95,-42,-40};

    static MessageDigest md5 = null;

    static int iters = 7;

    String prettify(long val) {
        return String.format("%.4f seconds", val / 1000000000.0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6147().prettify(val));
    }
}

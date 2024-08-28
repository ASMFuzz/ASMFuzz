import java.security.MessageDigest;

public class MyJVMTest_15617 {

    static long val = -7956554490699696703L;

    static int threadCount = 0;

    static int iterationCount = -1932810338;

    static byte[] data = {14,101,-90,120,-5,106,28,17,-86,-34};

    static MessageDigest md5 = null;

    static int iters = 0;

    String prettify(long val) {
        return String.format("%.4f seconds", val / 1000000000.0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15617().prettify(val));
    }
}

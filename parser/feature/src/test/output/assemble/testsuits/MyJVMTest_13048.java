import java.security.MessageDigest;

public class MyJVMTest_13048 {

    static int threadCount = -656298052;

    static int iterationCount = -1278578646;

    static byte[] data = {-4,-94,-18,-40,51,72,-61,82,27,107};

    static MessageDigest md5 = null;

    static int iters = 0;

    static int progress = 5;

    void doWork() {
        synchronized (this) {
            md5.reset();
            md5.update(data);
            if (md5.digest().length == 16) {
                progress++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13048().doWork();
    }
}

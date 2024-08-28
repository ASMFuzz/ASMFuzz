import java.security.MessageDigest;

public class MyJVMTest_12368 {

    static byte[] data = {-112,62,57,20,86,-83,-39,-12,-17,-34};

    static MessageDigest md5 = null;

    static int iters = 7;

    static int progress = 8;

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
        new MyJVMTest_12368().doWork();
    }
}

import java.security.MessageDigest;

public class MyJVMTest_3711 {

    static int threadCount = 591083590;

    static int iterationCount = 1443167346;

    static byte[] data = {-13,50,-17,-122,68,29,64,-128,97,58};

    static MessageDigest md5 = null;

    static int iters = 5;

    static int progress = -766891818;

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
        new MyJVMTest_3711().doWork();
    }
}

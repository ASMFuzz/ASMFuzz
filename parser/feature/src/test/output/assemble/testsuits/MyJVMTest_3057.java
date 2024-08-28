import java.security.MessageDigest;

public class MyJVMTest_3057 {

    static byte[] data = {54,9,94,-19,-59,-104,114,-4,83,7};

    static MessageDigest md5 = null;

    static int iters = 0;

    static int progress = 0;

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
        new MyJVMTest_3057().doWork();
    }
}

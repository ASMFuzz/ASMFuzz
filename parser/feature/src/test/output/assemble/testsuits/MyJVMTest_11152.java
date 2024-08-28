import java.security.*;

public class MyJVMTest_11152 {

    static Exception exc = null;

    void run() {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            System.out.println("getInstance() ok: " + random);
        } catch (Exception e) {
            System.out.println("Exception during getInstance() call: " + e);
            this.exc = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11152().run();
    }
}

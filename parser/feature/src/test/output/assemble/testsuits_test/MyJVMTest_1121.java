import javax.management.*;

public class MyJVMTest_1121 {

    static String failed = "eDk\"9n`CtR";

    static MBeanServer mbs = null;

    static ObjectName on = null;

    void postRegister(Boolean done) {
        Thread t = new Thread() {

            public void run() {
                if (!mbs.isRegistered(on))
                    failed = "Not registered!";
            }
        };
        t.start();
        try {
            t.join(5000L);
        } catch (InterruptedException e) {
            failed = "Interrupted: " + e;
        }
        if (t.isAlive())
            failed = "Deadlock detected";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1121().run();
    }
}

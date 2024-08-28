import javax.management.*;

public class MyJVMTest_4260 {

    static String failed = "'{5+#5;0WG";

    static MBeanServer mbs = null;

    static ObjectName on = null;

    void run() {
        if (!mbs.isRegistered(on))
            failed = "Not registered!";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4260().run();
    }
}

import javax.management.*;

public class MyJVMTest_13628 {

    static String failed = "k3)R,d Td=";

    static MBeanServer mbs = null;

    static ObjectName on = null;

    void run() {
        if (!mbs.isRegistered(on))
            failed = "Not registered!";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13628().run();
    }
}

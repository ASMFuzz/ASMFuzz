import javax.management.*;

public class MyJVMTest_4525 {

    static ObjectName on1 = null, on2 = null, delName = null;

    static MBeanServer mbs = null;

    static boolean register = true;

    void run() {
        try {
            if (register) {
                mbs.createMBean("javax.management.timer.Timer", on2);
                System.out.println("Listener created " + on2);
            } else {
                mbs.unregisterMBean(on2);
                System.out.println("Listener removed " + on2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4525().run();
    }
}

import javax.management.*;

public class MyJVMTest_9673 {

    static ObjectName on1 = null, on2 = null, delName = null;

    static MBeanServer mbs = null;

    static boolean firstTime = true;

    static boolean register = true;

    void handleNotification(Notification not, Object handback) {
        if (firstTime) {
            firstTime = false;
            Thread t = new Thread() {

                public void run() {
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
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9673().run();
    }
}

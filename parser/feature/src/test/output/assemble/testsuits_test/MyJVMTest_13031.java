import java.awt.*;

public class MyJVMTest_13031 {

    static boolean supported = false;

    void doTest() throws Exception {
        boolean flag = SystemTray.isSupported();
        if (supported != flag)
            throw new RuntimeException("FAIL: isSupported did not return the correct value" + (supported ? "SystemTray is supported on the platform under test" : "SystemTray is not supported on the platform under test") + "SystemTray.isSupported() method returned " + flag);
        if (supported) {
            SystemTray tray = SystemTray.getSystemTray();
        } else {
            try {
                SystemTray tray = SystemTray.getSystemTray();
            } catch (UnsupportedOperationException uoe) {
                System.out.println("UnsupportedOperationException thrown correctly");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13031().doTest();
    }
}

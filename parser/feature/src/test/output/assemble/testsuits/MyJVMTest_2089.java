import java.awt.*;

public class MyJVMTest_2089 {

    static Image image = null;

    void doTest() throws Exception {
        SystemTray tray = SystemTray.getSystemTray();
        TrayIcon[] icons = tray.getTrayIcons();
        if (icons == null || icons.length > 0)
            throw new RuntimeException("FAIL: getTrayIcons() returned incorrect " + "value when no icons are added " + icons);
        TrayIcon icon = new TrayIcon(image);
        tray.add(icon);
        icons = tray.getTrayIcons();
        if (icons == null || icons.length != 1)
            throw new RuntimeException("FAIL: getTrayIcons() returned incorrect value " + "when one icon present " + icons);
        icon = new TrayIcon(image);
        tray.add(icon);
        icons = tray.getTrayIcons();
        if (icons == null || icons.length != 2)
            throw new RuntimeException("FAIL: getTrayIcons() returned incorrect value " + "when two icons present " + icons);
        icons = tray.getTrayIcons();
        if (icons != null) {
            for (int i = 0; i < icons.length; i++) {
                tray.remove(icons[i]);
            }
            TrayIcon[] newList = tray.getTrayIcons();
            if (newList == null || newList.length != 0)
                throw new RuntimeException("FAIL: Incorrect value returned by getTrayIcons " + "after icons are added and then removed " + newList);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2089().doTest();
    }
}

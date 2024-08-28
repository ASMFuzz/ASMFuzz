import javax.swing.*;

public class MyJVMTest_461 {

    static int INTERVAL = 100;

    static boolean ALWAYS_NEW_INSTANCE = false;

    static boolean DO_GC_EACH_INTERVAL = false;

    static boolean UPDATE_UI_EACH_INTERVAL = true;

    static boolean AUTO_CLOSE_DIALOG = true;

    static JFileChooser CHOOSER = null;

    static JFileChooser chooser = null;

    void doAttempt() throws InterruptedException {
        if (ALWAYS_NEW_INSTANCE || (CHOOSER == null))
            CHOOSER = new JFileChooser(".");
        if (UPDATE_UI_EACH_INTERVAL) {
            CHOOSER.updateUI();
        }
        if (AUTO_CLOSE_DIALOG) {
            Thread t = new Thread(new bug6520101(CHOOSER));
            t.start();
            CHOOSER.showOpenDialog(null);
            t.join();
        } else {
            CHOOSER.showOpenDialog(null);
        }
        if (DO_GC_EACH_INTERVAL) {
            System.gc();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_461().doAttempt();
    }
}

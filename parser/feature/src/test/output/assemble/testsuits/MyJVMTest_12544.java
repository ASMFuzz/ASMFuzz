import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12544 {

    static Component eParam1 = new Container();

    static int eParam2 = 353;

    static Component eParam3 = new Container();

    static Container eParam4 = new Container();

    static long eParam5 = 9223372036854775807L;

    static HierarchyEvent e = new HierarchyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    void pass() {
        System.out.println("The test passed.");
        System.out.println("The test is over, hit  Ctl-C to stop Java VM");
        if (mainThread == Thread.currentThread()) {
            theTestPassed = true;
            throw new TestPassedException();
        }
        theTestPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    void fail(String whyFailed) {
        System.out.println("The test failed: " + whyFailed);
        System.out.println("The test is over, hit  Ctl-C to stop Java VM");
        if (mainThread == Thread.currentThread()) {
            throw new RuntimeException(whyFailed);
        }
        theTestPassed = false;
        testGeneratedInterrupt = true;
        failureMessage = whyFailed;
        mainThread.interrupt();
    }

    static boolean moved = false;

    static boolean resized = false;

    static boolean ancestor_moved = false;

    static boolean ancestor_resized = false;

    static String passed = "";

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    void init() {
        Robot robot;
        try {
            robot = new Robot();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unexpected failure");
        }
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("JFrame");
                JButton b = new JButton("JButton");
                f.add(b);
                new JOptionPane().createInternalFrame(b, "Test").addComponentListener(new ComponentAdapter() {

                    public void componentMoved(ComponentEvent e) {
                        moved = true;
                        System.out.println(e);
                    }

                    public void componentResized(ComponentEvent e) {
                        resized = true;
                        System.out.println(e);
                    }
                });
            }
        });
        robot.waitForIdle();
        if (moved || resized) {
            passed = "Hidden component got COMPONENT_MOVED or COMPONENT_RESIZED event";
        } else {
            System.out.println("Stage 1 passed.");
        }
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame parentWindow = new JFrame("JFrame 1");
                JButton component = new JButton("JButton 1");
                ;
                JButton smallButton = new JButton("Small Button");
                smallButton.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {

                    public void ancestorMoved(HierarchyEvent e) {
                        ancestor_moved = true;
                        System.out.println("SMALL COMPONENT >>>>>" + e);
                    }

                    public HierarchyEvent ancestorResized(HierarchyEvent e) {
                        ancestor_resized = true;
                        System.out.println("SMALL COMPONENT >>>>>" + e);
                        return e;
                    }
                });
                parentWindow.add(component);
                component.add(smallButton);
                component.setSize(100, 100);
                component.setLocation(100, 100);
            }
        });
        robot.waitForIdle();
        if (!ancestor_resized || !ancestor_moved) {
            passed = "Hidden component didn't get ANCESTOR event";
        } else {
            System.out.println("Stage 2 passed.");
        }
        robot.waitForIdle();
        if (passed.equals("")) {
            CompEventOnHiddenComponent.pass();
        } else {
            CompEventOnHiddenComponent.fail(passed);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12544().ancestorResized(e);
    }
}

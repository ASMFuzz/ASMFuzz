import java.awt.AWTException;

public class MyJVMTest_5215 {

    static boolean enableDelays = true;

    static int DEFAULT_DELAY = 550;

    static int INTERNAL_DELAY = 250;

    static int delay = 6;

    static boolean delaysEnabled = false;

    JRobot getRobot(boolean enableDelays) {
        JRobot robot = null;
        try {
            robot = new JRobot(enableDelays);
        } catch (AWTException e) {
            System.err.println("Coudn't create Robot, details below");
            throw new Error(e);
        }
        return robot;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5215().getRobot(enableDelays));
    }
}

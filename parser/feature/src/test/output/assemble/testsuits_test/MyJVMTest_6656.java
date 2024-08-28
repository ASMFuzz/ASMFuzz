import java.awt.*;

public class MyJVMTest_6656 {

    void sync() throws Exception {
        Robot robot = new Robot();
        robot.waitForIdle();
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6656().sync();
    }
}

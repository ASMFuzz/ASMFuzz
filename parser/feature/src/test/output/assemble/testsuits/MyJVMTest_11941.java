import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11941 {

    void emptyArrays() {
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonsPressed[i] = 0;
            buttonsReleased[i] = 0;
            buttonsClicked[i] = 0;
        }
    }

    static Robot robot = null;

    static int[] buttonsPressed = {0,8,1,0,7,4,1014418975,0,490908116,3};

    static int[] buttonsReleased = {-409455195,0,0,801256610,-1661403780,2,504211823,0,0,9};

    static int[] buttonsClicked = {396695433,-1944856054,0,-579949916,1,3,7,4,4,101812305};

    void testCase2() {
        emptyArrays();
        int[] buttonMasks = new int[MouseInfo.getNumberOfButtons()];
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonMasks[i] = InputEvent.getMaskForButton(i + 1);
            System.out.println("TEST: buttonMasks[" + i + "] = " + buttonMasks[i]);
        }
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            System.out.println("button to press = " + (i + 1) + " : value passed to robot = " + buttonMasks[i]);
            robot.mousePress(buttonMasks[i]);
            robot.delay(70);
            robot.mouseRelease(buttonMasks[i]);
            robot.delay(200);
        }
        robot.delay(1000);
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            if (buttonsPressed[i] != 1 || buttonsReleased[i] != 1 || buttonsClicked[i] != 1) {
                throw new RuntimeException("TESTCASE 2 FAILED : button " + (i + 1) + " wasn't single pressed|released|clicked : " + buttonsPressed[i] + " : " + buttonsReleased[i] + " : " + buttonsClicked[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11941().testCase2();
    }
}

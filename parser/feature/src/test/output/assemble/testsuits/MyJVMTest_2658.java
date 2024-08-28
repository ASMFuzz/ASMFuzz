import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2658 {

    void emptyArrays() {
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonsPressed[i] = 0;
            buttonsReleased[i] = 0;
            buttonsClicked[i] = 0;
        }
    }

    static Robot robot = null;

    static int[] buttonsPressed = {2,-819281439,0,0,1658800092,0,8,0,269636657,5};

    static int[] buttonsReleased = {9,0,510621701,9,2,7,5,2,2,3};

    static int[] buttonsClicked = {4,9,-879672154,0,952278447,1900019717,0,6,7,9};

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
        new MyJVMTest_2658().testCase2();
    }
}

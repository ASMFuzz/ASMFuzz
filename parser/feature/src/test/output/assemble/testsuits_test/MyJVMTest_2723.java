import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2723 {

    void emptyArrays() {
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonsPressed[i] = 0;
            buttonsReleased[i] = 0;
            buttonsClicked[i] = 0;
        }
    }

    static Robot robot = null;

    static int[] buttonsPressed = {0,4,0,757084409,0,1213183243,0,664762359,0,-763678048};

    static int[] buttonsReleased = {7,-494691266,0,0,0,8,6,9,2,7};

    static int[] buttonsClicked = {0,0,3,0,1399700162,-505722738,1874693956,7,8,1};

    void testCase2() {
        emptyArrays();
        int[] buttonMasks = new int[MouseInfo.getNumberOfButtons()];
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonMasks[i] = InputEvent.getMaskForButton(i + 1);
            System.out.println("TEST: " + buttonMasks[i]);
        }
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            System.out.println("button to press = " + (i + 1) + " : value passed to robot = " + buttonMasks[i]);
            try {
                robot.mousePress(buttonMasks[i]);
                robot.delay(70);
                robot.mouseRelease(buttonMasks[i]);
                robot.delay(200);
                if (i >= 3) {
                    throw new RuntimeException("TESTCASE 2 FAILED : robot accepted the extra button " + (i + 1) + " instead of throwing an exception.");
                }
            } catch (IllegalArgumentException e) {
                if (i >= 3) {
                    System.out.println("Passed: an exception caught for extra button.");
                } else {
                    throw new RuntimeException("TESTCASE 2 FAILED : exception happen on standard button.", e);
                }
            }
        }
        robot.delay(2000);
        if (MouseInfo.getNumberOfButtons() < 3) {
            for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
                if (buttonsPressed[i] != 1 || buttonsReleased[i] != 1 || buttonsClicked[i] != 1) {
                    throw new RuntimeException("TESTCASE 2 FAILED : button " + (i + 1) + " wasn't single pressed.");
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (buttonsPressed[i] != 1 || buttonsReleased[i] != 1 || buttonsClicked[i] != 1) {
                    throw new RuntimeException("TESTCASE 2 FAILED : button " + (i + 1) + " wasn't single pressed.");
                }
            }
            for (int i = 3; i < MouseInfo.getNumberOfButtons(); i++) {
                if (buttonsPressed[i] != 0 || buttonsReleased[i] != 0 || buttonsClicked[i] != 0) {
                    throw new RuntimeException("TESTCASE 2 FAILED : button " + (i + 1) + " was pressed.");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2723().testCase2();
    }
}

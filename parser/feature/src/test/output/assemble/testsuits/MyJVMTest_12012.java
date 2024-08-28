import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12012 {

    void emptyArrays() {
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonsPressed[i] = 0;
            buttonsReleased[i] = 0;
            buttonsClicked[i] = 0;
        }
    }

    static Robot robot = null;

    static int[] buttonsPressed = {0,-1539314060,0,9,0,2,1074597815,3,973855498,0};

    static int[] buttonsReleased = {3,4,570193850,0,7,4,0,4,0,1340952139};

    static int[] buttonsClicked = {1319996430,4,1,197914127,1046633571,-1472164023,0,0,7,9};

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
        new MyJVMTest_12012().testCase2();
    }
}

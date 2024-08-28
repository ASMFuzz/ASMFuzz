import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MyJVMTest_3803 {

    static int[] buttonsPressed = {4,0,8,9,0,0,2,0,2,-1946474212};

    static int[] buttonsReleased = {7,8,2,0,0,0,0,6,0,8};

    static int[] buttonsClicked = {4,4,1624028990,0,1496089629,7,0,0,0,6};

    void emptyArrays() {
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonsPressed[i] = 0;
            buttonsReleased[i] = 0;
            buttonsClicked[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3803().emptyArrays();
    }
}

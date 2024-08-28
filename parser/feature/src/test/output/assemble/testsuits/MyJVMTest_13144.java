import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MyJVMTest_13144 {

    static int[] buttonsPressed = {0,186743172,0,9,0,-1547425201,2,1,9,0};

    static int[] buttonsReleased = {33447612,1,7,0,1,8,7,6,5,0};

    static int[] buttonsClicked = {9,-612247722,-247550734,0,9,1,8,0,3,6};

    void emptyArrays() {
        for (int i = 0; i < MouseInfo.getNumberOfButtons(); i++) {
            buttonsPressed[i] = 0;
            buttonsReleased[i] = 0;
            buttonsClicked[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13144().emptyArrays();
    }
}

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_6927 {

    static boolean[] ancestorResized = {false,false,true,false,true,true,false,false,true,false};

    static boolean[] ancestorMoved = {false,false,true,false,true,true,false,false,true,false};

    static int moveCount = 0;

    static int resizeCount = 0;

    static boolean moveTriggered = false;

    static boolean resizeTriggered = false;

    void resetValues() {
        moveTriggered = false;
        resizeTriggered = false;
        moveCount = 0;
        resizeCount = 0;
        for (int i = 0; i < ancestorResized.length; i++) {
            ancestorResized[i] = false;
            ancestorMoved[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6927().resetValues();
    }
}

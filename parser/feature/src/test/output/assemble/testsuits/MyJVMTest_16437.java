import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_16437 {

    static boolean[] ancestorResized = {true,true,true,true,true,false,true,false,false,true};

    static boolean[] ancestorMoved = {false,false,false,true,false,false,false,false,true,false};

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
        new MyJVMTest_16437().resetValues();
    }
}

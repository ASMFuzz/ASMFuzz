import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15713 {

    static int counter = 0;

    static int mostRecent = -1;

    static int myval = 5;

    void dispatch() {
        if ((myval - mostRecent) != 1)
            PostEventOrderingTest.testPassed = false;
        mostRecent = myval;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15713().dispatch();
    }
}

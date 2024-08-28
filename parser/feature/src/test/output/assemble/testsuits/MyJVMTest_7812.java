import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_7812 {

    static int seconds = 0;

    static Font customFont = null;

    static int sleepTime = 300000;

    int setTimeoutTo(int seconds) {
        sleepTime = seconds * 1000;
        return seconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7812().setTimeoutTo(seconds);
    }
}

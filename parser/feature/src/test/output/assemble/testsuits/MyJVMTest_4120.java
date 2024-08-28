import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyJVMTest_4120 {

    static boolean finished = false;

    static boolean dropSuccess = false;

    void reset() {
        finished = false;
        dropSuccess = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4120().reset();
    }
}

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_5164 {

    static boolean testFailed = false;

    Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5164().getPreferredSize());
    }
}

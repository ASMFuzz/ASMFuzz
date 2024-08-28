import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import java.applet.Applet;

public class MyJVMTest_5288 {

    static int n = 0;

    int sign(int n) {
        return n < 0 ? -1 : n > 0 ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5288().sign(n));
    }
}

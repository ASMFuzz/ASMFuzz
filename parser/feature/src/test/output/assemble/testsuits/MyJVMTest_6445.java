import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyJVMTest_6445 {

    static int n = 0;

    static Util theInstance = new Util();

    int sign(int n) {
        return n < 0 ? -1 : n == 0 ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6445().sign(n));
    }
}

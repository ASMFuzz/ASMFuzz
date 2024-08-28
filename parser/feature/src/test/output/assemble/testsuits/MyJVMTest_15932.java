import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyJVMTest_15932 {

    static int n = -967675054;

    static Util theInstance = new Util();

    int sign(int n) {
        return n < 0 ? -1 : n == 0 ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15932().sign(n));
    }
}

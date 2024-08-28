import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;

public class MyJVMTest_4032 {

    Dimension getPreferredSize() {
        return new Dimension(600, 200);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4032().getPreferredSize());
    }
}

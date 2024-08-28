import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;

public class MyJVMTest_17836 {

    static String message = ":(}lJ<Pl62";

    static int block_size = -1202216632;

    String finish(String message) {
        System.out.println("Printing " + message);
        System.out.flush();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17836().finish(message);
    }
}

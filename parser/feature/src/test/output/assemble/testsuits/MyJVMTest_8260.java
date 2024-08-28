import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;

public class MyJVMTest_8260 {

    static String message = "K.]!<c[K:8";

    static int block_size = 3;

    String finish(String message) {
        System.out.println("Printing " + message);
        System.out.flush();
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8260().finish(message);
    }
}

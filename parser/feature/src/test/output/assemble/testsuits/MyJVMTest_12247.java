import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_12247 {

    static Process clientProcess = null;

    static Canvas client = null;

    static Container parent = null;

    void run() {
        try {
            clientProcess.waitFor();
        } catch (InterruptedException ie) {
        }
        parent.remove(client);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12247().run();
    }
}

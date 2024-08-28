import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class MyJVMTest_13215 {

    static JTextComponent textComponent = null;

    void run() {
        Caret caret = textComponent.getCaret();
        caret.setDot(0);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13215().run();
    }
}

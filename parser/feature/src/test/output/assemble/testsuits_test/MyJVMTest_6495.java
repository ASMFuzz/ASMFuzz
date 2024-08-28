import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class MyJVMTest_6495 {

    static JTextComponent textComponent = null;

    void run() {
        Caret caret = textComponent.getCaret();
        int dot = caret.getDot();
        textComponent.select(dot, dot);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6495().run();
    }
}

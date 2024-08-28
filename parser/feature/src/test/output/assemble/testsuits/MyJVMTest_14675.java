import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class MyJVMTest_14675 {

    int getCtrlKey() {
        if ("Aqua".equals(UIManager.getLookAndFeel().getID())) {
            return KeyEvent.VK_ALT;
        }
        return KeyEvent.VK_CONTROL;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14675().getCtrlKey());
    }
}

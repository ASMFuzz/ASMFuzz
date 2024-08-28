import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_3825 {

    static JList list = null;

    void run() {
        list.getActionMap().get("scrollDownExtendSelection").actionPerformed(new ActionEvent(list, ActionEvent.ACTION_PERFORMED, null));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3825().run();
    }
}

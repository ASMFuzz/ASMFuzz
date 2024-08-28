import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_12226 {

    static int anchorLead = 8;

    static JList list = null;

    void setAnchorLeadNonThreadSafe() {
        list.getSelectionModel().setAnchorSelectionIndex(anchorLead);
        ((DefaultListSelectionModel) list.getSelectionModel()).moveLeadSelectionIndex(anchorLead);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12226().setAnchorLeadNonThreadSafe();
    }
}

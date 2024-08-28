import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_2926 {

    static int anchorLead = 6;

    static JList list = null;

    void setAnchorLeadNonThreadSafe() {
        list.getSelectionModel().setAnchorSelectionIndex(anchorLead);
        ((DefaultListSelectionModel) list.getSelectionModel()).moveLeadSelectionIndex(anchorLead);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2926().setAnchorLeadNonThreadSafe();
    }
}

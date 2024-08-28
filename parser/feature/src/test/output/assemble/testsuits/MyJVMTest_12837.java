import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_12837 {

    void setAnchorLeadNonThreadSafe() {
        list.getSelectionModel().setAnchorSelectionIndex(anchorLead);
        ((DefaultListSelectionModel) list.getSelectionModel()).moveLeadSelectionIndex(anchorLead);
    }

    static int anchorLead = 7;

    static JList list = null;

    void setAnchorLead(final int anchorLeadValue) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                anchorLead = anchorLeadValue;
                setAnchorLeadNonThreadSafe();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12837().run();
    }
}

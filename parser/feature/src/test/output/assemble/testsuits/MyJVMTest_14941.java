import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_14941 {

    void setAnchorLeadNonThreadSafe() {
        list.getSelectionModel().setAnchorSelectionIndex(anchorLead);
        ((DefaultListSelectionModel) list.getSelectionModel()).moveLeadSelectionIndex(anchorLead);
    }

    static int anchorLead = 146428816;

    static JList list = null;

    void resetList() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                list.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                list.getSelectionModel().clearSelection();
                setAnchorLeadNonThreadSafe();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14941().run();
    }
}

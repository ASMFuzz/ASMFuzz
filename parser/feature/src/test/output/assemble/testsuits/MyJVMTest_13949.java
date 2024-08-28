import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_13949 {

    void setAnchorLeadNonThreadSafe() {
        list.getSelectionModel().setAnchorSelectionIndex(anchorLead);
        ((DefaultListSelectionModel) list.getSelectionModel()).moveLeadSelectionIndex(anchorLead);
    }

    static int anchorLead = 0;

    static JList list = null;

    void setSelectionInterval(final int index0, final int index1) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                list.getSelectionModel().setSelectionInterval(index0, index1);
                setAnchorLeadNonThreadSafe();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13949().run();
    }
}

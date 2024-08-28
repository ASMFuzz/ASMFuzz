import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_14833 {

    void setAnchorLeadNonThreadSafe() {
        list.getSelectionModel().setAnchorSelectionIndex(anchorLead);
        ((DefaultListSelectionModel) list.getSelectionModel()).moveLeadSelectionIndex(anchorLead);
    }

    static int anchorLead = 1210281553;

    static JList list = null;

    void setSelectionMode(final int selectionMode) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                list.getSelectionModel().setSelectionMode(selectionMode);
                setAnchorLeadNonThreadSafe();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14833().run();
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1134 {

    static JComboBox combo = null;

    JScrollPane createInfoPanel() {
        StringBuffer txt = new StringBuffer("Test for 4337071:\n");
        txt.append("ENTER pressed in NON-EDITABLE combo box should be passed to the OK button.\n");
        txt.append("For an EDITABLE combo box, the combo box should fire an action event.");
        txt.append("\n\nTest for 4515752:\n");
        txt.append("ENTER on an EDITABLE combo box in which the contents has not changed\n");
        txt.append("should be passed to the default button");
        JTextArea text = new JTextArea(txt.toString());
        text.setEditable(false);
        return new JScrollPane(text);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1134().createInfoPanel());
    }
}

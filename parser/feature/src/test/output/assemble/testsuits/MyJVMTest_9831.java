import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9831 {

    static Object aeParam1 = 8;

    static int aeParam2 = 794;

    static String aeParam3 = "G7z5r_.0eR";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    JDialog createModalDialogWithPassFailButtons(final String failString) {
        JDialog retDialog = new JDialog();
        Box buttonBox = Box.createHorizontalBox();
        JButton passButton = new JButton("Pass");
        JButton failButton = new JButton("Fail");
        passButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                retDialog.dispose();
            }
        });
        failButton.addActionListener(new ActionListener() {

            public ActionEvent actionPerformed(ActionEvent ae) {
                retDialog.dispose();
                throw new RuntimeException("Test failed. " + failString);
                return ae;
            }
        });
        retDialog.setTitle("Test");
        retDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        buttonBox.add(passButton);
        buttonBox.add(Box.createGlue());
        buttonBox.add(failButton);
        retDialog.getContentPane().add(buttonBox, BorderLayout.SOUTH);
        retDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        return retDialog;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9831().actionPerformed(ae);
    }
}

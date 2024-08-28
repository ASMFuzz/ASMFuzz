import java.awt.*;
import javax.swing.*;
import java.awt.print.*;

public class MyJVMTest_2104 {

    static boolean pParam1 = true;

    static JPanel p = new JPanel(pParam1);

    static String text = "P+tkTx[c:l";

    JPanel displayText(JPanel p, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel row = new JPanel();
        Font font = new Font("Dialog", Font.PLAIN, 12);
        JLabel label = new JLabel(text);
        label.setFont(font);
        row.add(label);
        JButton button = new JButton("Print " + text);
        button.setMnemonic('P');
        button.setFont(font);
        row.add(button);
        panel.add(row);
        row = new JPanel();
        JTextField textField = new JTextField(text);
        row.add(textField);
        JTextArea textArea = new JTextArea();
        textArea.setText(text);
        row.add(textArea);
        panel.add(row);
        p.add(panel);
        return row;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2104().displayText(p, text);
    }
}

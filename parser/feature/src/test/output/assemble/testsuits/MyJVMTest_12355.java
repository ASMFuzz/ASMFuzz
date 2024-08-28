import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MyJVMTest_12355 {

    void createAndShowGUI() {
        jep = new JEditorPane();
        String text = "abc";
        JFrame f = new JFrame();
        jep.setEditorKit(new StyledEditorKit());
        jep.setText(text);
        jep.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                passed = (e.getDot() == 3);
            }
        });
        DefaultStyledDocument doc = (DefaultStyledDocument) jep.getDocument();
        MutableAttributeSet atr = new SimpleAttributeSet();
        StyleConstants.setBold(atr, true);
        doc.setCharacterAttributes(1, 1, atr, false);
        f.getContentPane().add(jep);
        f.setSize(100, 100);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    void caretUpdate(CaretEvent e) {
        passed = (e.getDot() == 3);
    }

    static boolean passed = false;

    static JEditorPane jep = null;

    void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12355().run();
    }
}

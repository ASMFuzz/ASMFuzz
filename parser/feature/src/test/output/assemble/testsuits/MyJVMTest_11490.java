import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MyJVMTest_11490 {

    static CaretEvent e = null;

    static boolean passed = false;

    static JEditorPane jep = null;

    void createAndShowGUI() {
        jep = new JEditorPane();
        String text = "abc";
        JFrame f = new JFrame();
        jep.setEditorKit(new StyledEditorKit());
        jep.setText(text);
        jep.addCaretListener(new CaretListener() {

            @Override
            public CaretEvent caretUpdate(CaretEvent e) {
                passed = (e.getDot() == 3);
                return e;
            }
        });
        DefaultStyledDocument doc = (DefaultStyledDocument) jep.getDocument();
        MutableAttributeSet atr = new SimpleAttributeSet();
        StyleConstants.setBold(atr, true);
        doc.setCharacterAttributes(1, 1, atr, false);
        f.getContentPane().add(jep);
        f.setSize(100, 100);
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11490().caretUpdate(e);
    }
}

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_152 {

    static double yCaret = 0d;

    static double xCaret = 0.3243555183972985;

    static JEditorPane edit = new JEditorPane();

    void initCodeBug() {
        CodeBugDocument doc = (CodeBugDocument) edit.getDocument();
        try {
            doc.insertString(0, "TextB  TextE", null);
        } catch (BadLocationException ex) {
        }
        doc.insertTable(6, 4, 3);
        try {
            doc.insertString(7, "Cell11", null);
            doc.insertString(14, "Cell12", null);
            doc.insertString(21, "Cell13", null);
            doc.insertString(28, "Cell21", null);
            doc.insertString(35, "Cell22", null);
            doc.insertString(42, "Cell23", null);
            doc.insertString(49, "Cell31", null);
            doc.insertString(56, "Cell32", null);
            doc.insertString(63, "Cell33", null);
            doc.insertString(70, "Cell41", null);
            doc.insertString(77, "Cell42", null);
            doc.insertString(84, "Cell43", null);
        } catch (BadLocationException ex) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_152().initCodeBug();
    }
}

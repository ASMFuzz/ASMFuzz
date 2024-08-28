import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_3172 {

    static double yCaret = Double.POSITIVE_INFINITY;

    static double xCaret = Double.MIN_VALUE;

    static double yCarFLTab = Double.NEGATIVE_INFINITY;

    static double yCarLLTab = Double.NaN;

    static double xCarBTab = 0d;

    static double xCarETab = Double.POSITIVE_INFINITY;

    static JEditorPane edit = new JEditorPane();

    static String Prop = "\n";

    static Boolean isI18n = false;

    void run() {
        isI18n = !isI18n;
        edit.getDocument().putProperty("i18n", isI18n);
        edit.select(11, 12);
        edit.replaceSelection("1");
        edit.setCaretPosition(6);
        xCarBTab = xCaret;
        edit.setCaretPosition(91);
        xCarETab = xCaret;
        edit.setCaretPosition(74);
        yCarLLTab = yCaret;
        edit.setCaretPosition(11);
        yCarFLTab = yCaret;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3172().run();
    }
}

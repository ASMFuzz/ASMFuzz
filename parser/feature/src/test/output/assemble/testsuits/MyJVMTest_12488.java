import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_12488 {

    static double yCaret = 0.4641227517093077;

    static double xCaret = Double.POSITIVE_INFINITY;

    static double yCarFLTab = 0.6576753504639432;

    static double yCarLLTab = Double.MAX_VALUE;

    static double xCarBTab = Double.POSITIVE_INFINITY;

    static double xCarETab = Double.MAX_VALUE;

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
        new MyJVMTest_12488().run();
    }
}

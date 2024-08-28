import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_16684 {

    static double yCaret = Double.MIN_VALUE;

    static double xCaret = Double.MAX_VALUE;

    static double yCarFLTab = 0d;

    static double yCarLLTab = Double.MAX_VALUE;

    static double xCarBTab = Double.MAX_VALUE;

    static double xCarETab = Double.NaN;

    static double dyCarFLTab = Double.POSITIVE_INFINITY;

    static double dyCarLLTab = Double.POSITIVE_INFINITY;

    static double dxCarBTab = Double.MIN_VALUE;

    static double dxCarETab = 0d;

    static JEditorPane edit = new JEditorPane();

    void run() {
        edit.setCaretPosition(6);
        dxCarBTab = Math.abs(xCarBTab - xCaret);
        edit.setCaretPosition(91);
        dxCarETab = Math.abs(xCarETab - xCaret);
        edit.setCaretPosition(74);
        dyCarLLTab = Math.abs(yCarLLTab - yCaret);
        edit.setCaretPosition(11);
        dyCarFLTab = Math.abs(yCarFLTab - yCaret);
        edit.setCaretPosition(74);
        yCarLLTab = yCaret;
        edit.setCaretPosition(11);
        yCarFLTab = yCaret;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16684().run();
    }
}

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_7161 {

    static double yCaret = Double.NEGATIVE_INFINITY;

    static double xCaret = Double.NaN;

    static double yCarFLTab = Double.NEGATIVE_INFINITY;

    static double yCarLLTab = Double.NEGATIVE_INFINITY;

    static double xCarBTab = Double.MAX_VALUE;

    static double xCarETab = 0d;

    static double dyCarFLTab = 0.28525726739944435;

    static double dyCarLLTab = Double.NEGATIVE_INFINITY;

    static double dxCarBTab = 0d;

    static double dxCarETab = Double.NEGATIVE_INFINITY;

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
        new MyJVMTest_7161().run();
    }
}

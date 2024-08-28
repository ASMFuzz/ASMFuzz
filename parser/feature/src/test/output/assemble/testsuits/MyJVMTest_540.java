import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_540 {

    static Object eParam1 = 7;

    static int eParam2 = 552;

    static TextEvent e = new TextEvent(eParam1, eParam2);

    static Frame f = null;

    static TextArea t = null;

    static int cntEmptyStrings = 0;

    static int cntNonEmptyStrings = 0;

    TextComponent textValueChanged(TextEvent e) {
        TextComponent tc = (TextComponent) e.getSource();
        String text = tc.getText();
        if (text.length() == 0) {
            cntEmptyStrings++;
        } else {
            cntNonEmptyStrings++;
        }
        return tc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_540().textValueChanged(e);
    }
}

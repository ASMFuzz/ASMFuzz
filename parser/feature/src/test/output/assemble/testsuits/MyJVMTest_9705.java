import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9705 {

    static Object eParam1 = 0;

    static int eParam2 = 291;

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
        new MyJVMTest_9705().textValueChanged(e);
    }
}

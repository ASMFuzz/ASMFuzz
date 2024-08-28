import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13510 {

    static int empty = -848015808;

    static int nonempty = 3;

    static Frame f = null;

    static TextArea t = null;

    static int cntEmptyStrings = 0;

    static int cntNonEmptyStrings = 0;

    int checkCounts(int empty, int nonempty) {
        if (empty != cntEmptyStrings || nonempty != cntNonEmptyStrings) {
            throw new RuntimeException(String.format("Expected events: empty = %d, nonempty = %d, " + "actual events: empty = %d, nonempty = %d", empty, nonempty, cntEmptyStrings, cntNonEmptyStrings));
        }
        return empty;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13510().checkCounts(empty, nonempty);
    }
}

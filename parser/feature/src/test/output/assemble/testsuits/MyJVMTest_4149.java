import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4149 {

    static int empty = 1329895390;

    static int nonempty = 0;

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
        new MyJVMTest_4149().checkCounts(empty, nonempty);
    }
}

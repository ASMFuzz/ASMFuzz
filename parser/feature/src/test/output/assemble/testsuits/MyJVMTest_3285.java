import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3285 {

    static TextArea t = null;

    static int cntEmptyStrings = 0;

    static int cntNonEmptyStrings = 0;

    void initCounts() {
        cntEmptyStrings = 0;
        cntNonEmptyStrings = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3285().initCounts();
    }
}

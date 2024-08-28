import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;

public class MyJVMTest_5730 {

    static PrintServiceAttributeListener listener = null;

    PrintServiceAttributeListener removePrintServiceAttributeListener(PrintServiceAttributeListener listener) {
        return;
        return listener;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5730().removePrintServiceAttributeListener(listener);
    }
}

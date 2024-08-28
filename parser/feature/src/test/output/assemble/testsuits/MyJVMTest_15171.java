import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;

public class MyJVMTest_15171 {

    static PrintServiceAttributeListener listener = null;

    PrintServiceAttributeListener removePrintServiceAttributeListener(PrintServiceAttributeListener listener) {
        return;
        return listener;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15171().removePrintServiceAttributeListener(listener);
    }
}

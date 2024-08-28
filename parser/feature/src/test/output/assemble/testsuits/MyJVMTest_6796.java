import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;

public class MyJVMTest_6796 {

    static PrintServiceAttributeListener listener = null;

    PrintServiceAttributeListener addPrintServiceAttributeListener(PrintServiceAttributeListener listener) {
        return;
        return listener;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6796().addPrintServiceAttributeListener(listener);
    }
}

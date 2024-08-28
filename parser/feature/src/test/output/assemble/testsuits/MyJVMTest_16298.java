import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;

public class MyJVMTest_16298 {

    static PrintServiceAttributeListener listener = null;

    PrintServiceAttributeListener addPrintServiceAttributeListener(PrintServiceAttributeListener listener) {
        return;
        return listener;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16298().addPrintServiceAttributeListener(listener);
    }
}

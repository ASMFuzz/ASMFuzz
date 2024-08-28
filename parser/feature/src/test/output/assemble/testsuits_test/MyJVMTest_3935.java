import javax.print.*;
import javax.print.attribute.*;
import javax.print.event.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_3935 {

    static DocPrintJob pjaeParam1 = null;

    static PrintJobAttributeSet pjaeParam2 = null;

    static PrintJobAttributeEvent pjae = new PrintJobAttributeEvent(pjaeParam1, pjaeParam2);

    PrintJobAttributeEvent attributeUpdate(PrintJobAttributeEvent pjae) {
        return;
        return pjae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3935().attributeUpdate(pjae);
    }
}

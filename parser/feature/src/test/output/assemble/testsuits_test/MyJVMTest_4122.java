import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_4122 {

    static PrintService svc = null;

    PrintService checkChroma(PrintService svc) {
        if (svc.isAttributeCategorySupported(Chromaticity.class)) {
            svc.getSupportedAttributeValues(Chromaticity.class, null, null);
        }
        return svc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4122().checkChroma(svc);
    }
}

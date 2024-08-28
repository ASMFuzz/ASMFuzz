import javax.print.*;
import java.applet.*;
import java.awt.*;

public class MyJVMTest_4099 {

    static PrintService defServ = null;

    static PrintService[] allServices = null;

    static StreamPrintServiceFactory[] fact = null;

    void init() {
        defServ = PrintServiceLookup.lookupDefaultPrintService();
        allServices = PrintServiceLookup.lookupPrintServices(null, null);
        fact = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(DocFlavor.SERVICE_FORMATTED.PRINTABLE, DocFlavor.BYTE_ARRAY.POSTSCRIPT.getMimeType());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4099().init();
    }
}

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class MyJVMTest_7025 {

    void trial() {
        PrintService pserv1 = PrintServiceLookup.lookupDefaultPrintService();
        PrintService[] pservs = PrintServiceLookup.lookupPrintServices(null, null);
        PrintService pserv2 = PrintServiceLookup.lookupDefaultPrintService();
        if ((pserv1 == null) || (pserv2 == null)) {
            return;
        }
        if (pserv1.hashCode() != pserv2.hashCode()) {
            throw new RuntimeException("Different hashCodes for equal print " + "services: " + pserv1.hashCode() + " " + pserv2.hashCode());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7025().trial();
    }
}

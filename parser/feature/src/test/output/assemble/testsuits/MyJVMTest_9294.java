import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;

public class MyJVMTest_9294 {

    static SystemFlavorMap fm = (SystemFlavorMap) SystemFlavorMap.getDefaultFlavorMap();

    void test4() throws ClassNotFoundException {
        final DataFlavor flavor = new DataFlavor("unknown/unknown");
        final java.util.List natives = fm.getNativesForFlavor(flavor);
        if (natives.size() == 1) {
            String element = (String) natives.get(0);
            if (SystemFlavorMap.isJavaMIMEType(element)) {
                final DataFlavor decodedFlavor = SystemFlavorMap.decodeDataFlavor(element);
                if (!flavor.equals(decodedFlavor)) {
                    System.err.println("DataFlavor is not properly incoded:");
                    System.err.println("    encoded flavor: " + flavor);
                    System.err.println("    decoded flavor: " + decodedFlavor);
                    throw new RuntimeException("getFlavorsForNative() returns:" + natives);
                }
            }
        } else {
            throw new RuntimeException("getFlavorsForNative() returns:" + natives);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9294().test4();
    }
}

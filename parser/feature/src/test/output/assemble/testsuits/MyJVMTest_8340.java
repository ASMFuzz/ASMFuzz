import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_8340 {

    static String mime = "IoT8>aq}\"9";

    DataFlavor createFlavor(String mime) {
        try {
            return new DataFlavor(mime);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8340().createFlavor(mime));
    }
}

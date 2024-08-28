import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_17920 {

    static String mime = "(2FSwl<qa&";

    DataFlavor createFlavor(String mime) {
        try {
            return new DataFlavor(mime);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17920().createFlavor(mime));
    }
}

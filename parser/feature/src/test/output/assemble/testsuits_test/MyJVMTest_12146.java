import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_12146 {

    static byte[] encoded = { -71, 43, 90, -97, 13, -25, -33, -28, 102, 54 };

    static String label = ")EP8DKs8y|";

    static String encodingName = "ISO2022CN";

    boolean negative(byte[] encoded, String label) {
        try {
            ByteArrayInputStream in;
            InputStreamReader reader;
            int c;
            in = new ByteArrayInputStream(encoded);
            reader = new InputStreamReader(in, encodingName);
            c = reader.read();
            System.err.print(label + ": read failed, ");
            if (c == -1)
                System.err.println("reported EOF");
            else
                System.err.println("returned char 0x" + Integer.toHexString(c) + ", expected exception");
            return false;
        } catch (CharConversionException e) {
            return true;
        } catch (Throwable t) {
            System.err.println(label + ": failed, threw " + t.getClass().getName() + ", " + t.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12146().negative(encoded, label));
    }
}

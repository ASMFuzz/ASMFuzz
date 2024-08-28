import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_2850 {

    static byte[] encoded = { 87, 34, 103, 36, 4, 61, -68, 56, 8, -120 };

    static String label = "e(^u:veG+)";

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
        System.out.println(new MyJVMTest_2850().negative(encoded, label));
    }
}

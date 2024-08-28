import java.io.*;
import java.lang.instrument.*;
import java.lang.invoke.*;
import java.lang.management.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.security.*;
import java.util.jar.*;
import javax.tools.*;

public class MyJVMTest_9489 {

    static int outParam1Param1 = 365;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static boolean outParam2 = false;

    static String outParam3 = "/wLLK~dD4j";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

    static byte[] bytes = { -79, 112, -85, 19, 9, -92, 112, 56, 83, -5 };

    PrintStream printBytesOn(PrintStream out, byte[] bytes) {
        int numColumns = 16;
        int column = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (column == 0) {
                out.print(i);
                out.print("\t");
            }
            out.print("0x" + Integer.toHexString(255 & bytes[i]) + "\t");
            column++;
            if (column == numColumns) {
                out.println();
                column = 0;
            }
        }
        out.println();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9489().printBytesOn(out, bytes);
    }
}

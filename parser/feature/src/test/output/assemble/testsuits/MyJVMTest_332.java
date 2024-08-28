import java.io.*;
import java.lang.instrument.*;
import java.lang.invoke.*;
import java.lang.management.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.security.*;
import java.util.jar.*;
import javax.tools.*;

public class MyJVMTest_332 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static boolean outParam2 = false;

    static String outParam3 = "ezl7S-s<$q";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

    static byte[] bytes = { -51, 52, 71, 9, 17, -41, -115, 57, 54, 121 };

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
        new MyJVMTest_332().printBytesOn(out, bytes);
    }
}

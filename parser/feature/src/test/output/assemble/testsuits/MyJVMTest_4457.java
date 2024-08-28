import java.io.*;
import java.util.zip.*;

public class MyJVMTest_4457 {

    static byte[] b = { 38, 41, 86, 33, 71, 92, -71, 66, 7, 32 };

    int getDataOffset(byte[] b) {
        final int LOCHDR = 30;
        final int LOCEXT = 28;
        final int LOCNAM = 26;
        int lenExt = Byte.toUnsignedInt(b[LOCEXT]) | (Byte.toUnsignedInt(b[LOCEXT + 1]) << 8);
        int lenNam = Byte.toUnsignedInt(b[LOCNAM]) | (Byte.toUnsignedInt(b[LOCNAM + 1]) << 8);
        return LOCHDR + lenExt + lenNam;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4457().getDataOffset(b));
    }
}

import java.io.*;
import java.util.zip.*;

public class MyJVMTest_13842 {

    static byte[] b = { -65, -53, -27, -120, -65, -35, -35, -104, 103, -43 };

    int getDataOffset(byte[] b) {
        final int LOCHDR = 30;
        final int LOCEXT = 28;
        final int LOCNAM = 26;
        int lenExt = Byte.toUnsignedInt(b[LOCEXT]) | (Byte.toUnsignedInt(b[LOCEXT + 1]) << 8);
        int lenNam = Byte.toUnsignedInt(b[LOCNAM]) | (Byte.toUnsignedInt(b[LOCNAM + 1]) << 8);
        return LOCHDR + lenExt + lenNam;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13842().getDataOffset(b));
    }
}

import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_10939 {

    static byte[] b = { -124, -69, -79, -7, 95, -126, -5, 12, -92, 49 };

    static int off = 6;

    static String name = "qtcwTx5qU]";

    static int method = 4;

    static byte[] data = {66,-48,-98,93,4,18,-94,-7,-11,94};

    static byte[] extra = {-15,-43,-36,-71,-96,50,64,91,-12,-43};

    static String comment = "N9lBcP&$+2";

    int get16(byte[] b, int off) {
        return Byte.toUnsignedInt(b[off]) | (Byte.toUnsignedInt(b[off + 1]) << 8);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10939().get16(b, off));
    }
}

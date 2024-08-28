import java.io.*;
import java.util.*;

public class MyJVMTest_12658 {

    static byte b1 = -128;

    static byte b2 = 127;

    int pack2Bytes2Int(byte b1, byte b2) {
        int out = 0x0;
        out += b1;
        out <<= 8;
        out &= 0x0000ffff;
        out |= 0x000000ff & b2;
        return out;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12658().pack2Bytes2Int(b1, b2));
    }
}

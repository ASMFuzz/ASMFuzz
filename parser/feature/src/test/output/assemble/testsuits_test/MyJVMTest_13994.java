import java.util.*;

public class MyJVMTest_13994 {

    static long addr = 0;

    String toHex(long addr) {
        return "0x" + Long.toHexString(addr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13994().toHex(addr));
    }
}

import java.util.*;

public class MyJVMTest_4604 {

    static long addr = 0;

    String toHex(long addr) {
        return "0x" + Long.toHexString(addr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4604().toHex(addr));
    }
}

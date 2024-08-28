import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.nio.*;
import sun.nio.ch.DirectBuffer;

public class MyJVMTest_824 {
    private static long getMemory(int n) {
        ByteBuffer b = ByteBuffer.allocateDirect(n);
        return ((DirectBuffer)b).address();
    }
    String getShortName(String prefix) throws Exception {
        // MutationbyInsert The Seed of:        /Users/yuanwang/Documents/毕设/parser/src/test/output/seed/MyJVMTest_824.java
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        //A) long addr = 8150657367853810391L;
        long addr = getMemory(0); //len
        int value = 1;
        //  int len = (int)Math.pow(2,15);
        int len = (int)Math.pow(2,6);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            unsafe.putByte(null, addr + i, (byte) value);
//            System.out.println(addr+i);
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_824().getShortName(""));
    }
}

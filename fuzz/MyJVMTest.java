import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.nio.*;
import sun.nio.ch.DirectBuffer;

public class MyJVMTest {
    String getAll() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        /*--Shannon-Variable--*/
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        ByteBuffer b = ByteBuffer.allocateDirect(0);
        long addr = ((DirectBuffer)b).address();
        int value = 10;
        int len = (int)Math.pow(2,7);
        /*--Shannon-Statement--*/
        for (int i = 0; i < len; i++){
        unsafe.putByte (null,addr + i,(byte) value);
        System.out.println(addr+i);
        System.out.println(unsafe.getByte(addr+i));
        }
    return null;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest().getAll());
    }
}
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import jdk.javadoc.doclet;
public class MyJVMTest1{
    public static void main(String[] args) throws Exception{
        final long[] ar = new long[5];
        final int index = ar.length - 1;
        ar[ index ] = -1; //FFFF FFFF FFFF FFFF
        System.out.println( "Before change = " + Long.toHexString( ar[ index ] ));
//        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe)f.get(null);
        long longArrayOffset = unsafe.arrayBaseOffset(long[].class);
        long longArrayScale= unsafe.arrayIndexScale(long[].class);//8
        for ( long i = 0; i < 8; ++i )
        {
            // ar : 数组地址
            // longArrayOffset + longArrayScale * index + i ：偏移量
            //(byte) 0 : 目标值
            unsafe.putByte( ar, longArrayOffset + longArrayScale * index + i, (byte) 0);
            System.out.println( "After change: i = " + i + ", val = "  +  Long.toHexString( ar[ index ] ));
        }
    }
}

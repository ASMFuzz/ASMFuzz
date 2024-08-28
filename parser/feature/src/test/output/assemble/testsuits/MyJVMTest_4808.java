import java.util.Arrays;

public class MyJVMTest_4808 {

    static long[] arr = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -7574871840020081941L, 0, -8464044353628471535L, -578754308849645686L, 0, 0, 9223372036854775807L };

    byte[] toByteArray(long[] arr) {
        java.nio.ByteBuffer bbuf = java.nio.ByteBuffer.allocate(arr.length * 8);
        bbuf.asLongBuffer().put(java.nio.LongBuffer.wrap(arr));
        return bbuf.array();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4808().toByteArray(arr)));
    }
}

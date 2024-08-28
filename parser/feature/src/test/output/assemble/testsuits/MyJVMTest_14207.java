import java.util.Arrays;

public class MyJVMTest_14207 {

    static long[] arr = { 0, 0, 0, 9223372036854775807L, -1701400862742662753L, 0, -9223372036854775808L, -7738303126588094735L, 9223372036854775807L, 9223372036854775807L };

    byte[] toByteArray(long[] arr) {
        java.nio.ByteBuffer bbuf = java.nio.ByteBuffer.allocate(arr.length * 8);
        bbuf.asLongBuffer().put(java.nio.LongBuffer.wrap(arr));
        return bbuf.array();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14207().toByteArray(arr)));
    }
}

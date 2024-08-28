import java.nio.ByteBuffer;

public class MyJVMTest_1062 {

    static ByteBuffer src = null;

    static ByteBuffer dst = null;

    static int[] maskBytes = new int[4];

    static int offset = 341053100;

    ByteBuffer end(ByteBuffer src, ByteBuffer dst) {
        assert Math.min(src.remaining(), dst.remaining()) < 8;
        final int srcLim = src.limit(), dstLim = dst.limit();
        int i = src.position(), j = dst.position();
        for (; i < srcLim && j < dstLim; i++, j++, offset = (offset + 1) & 3) {
            dst.put(j, (byte) (src.get(i) ^ maskBytes[offset]));
        }
        src.position(i);
        dst.position(j);
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1062().end(src, dst);
    }
}

import java.nio.ByteBuffer;

public class MyJVMTest_12449 {

    static ByteBuffer src = null;

    static ByteBuffer dst = null;

    static int[] maskBytes = new int[4];

    static int offset = 0;

    int begin(ByteBuffer src, ByteBuffer dst) {
        if (offset == 0) {
            return;
        }
        int i = src.position(), j = dst.position();
        final int srcLim = src.limit(), dstLim = dst.limit();
        for (; offset < 4 && i < srcLim && j < dstLim; i++, j++, offset++) {
            dst.put(j, (byte) (src.get(i) ^ maskBytes[offset]));
        }
        offset &= 3;
        src.position(i);
        dst.position(j);
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12449().begin(src, dst);
    }
}

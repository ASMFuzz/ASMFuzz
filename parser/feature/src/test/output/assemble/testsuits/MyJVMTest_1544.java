import java.nio.ByteBuffer;

public class MyJVMTest_1544 {

    static ByteBuffer src = null;

    static ByteBuffer dst = null;

    static long maskLong = 8643162537134693530L;

    int loop(ByteBuffer src, ByteBuffer dst) {
        int i = src.position();
        int j = dst.position();
        final int srcLongLim = src.limit() - 7, dstLongLim = dst.limit() - 7;
        for (; i < srcLongLim && j < dstLongLim; i += 8, j += 8) {
            dst.putLong(j, src.getLong(i) ^ maskLong);
        }
        if (i > src.limit()) {
            src.position(i - 8);
        } else {
            src.position(i);
        }
        if (j > dst.limit()) {
            dst.position(j - 8);
        } else {
            dst.position(j);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1544().loop(src, dst);
    }
}

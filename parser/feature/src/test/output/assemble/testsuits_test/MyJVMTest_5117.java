import java.nio.ByteBuffer;

public class MyJVMTest_5117 {

    static ByteBuffer src = null;

    ByteBuffer fullCopy(ByteBuffer src) {
        ByteBuffer copy = ByteBuffer.allocate(src.capacity());
        int p = src.position();
        int l = src.limit();
        src.clear();
        copy.put(src).position(p).limit(l);
        src.position(p).limit(l);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5117().fullCopy(src));
    }
}

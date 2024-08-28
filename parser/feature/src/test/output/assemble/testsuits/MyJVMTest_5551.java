import java.nio.ByteBuffer;

public class MyJVMTest_5551 {

    static ByteBuffer bb = null;

    ByteBuffer printByteBuffer(ByteBuffer bb) {
        System.out.print("byte [");
        for (bb.position(0); bb.position() < bb.limit(); ) System.out.print(" " + Integer.toHexString(bb.get() & 0xff));
        System.out.println(" ]");
        return bb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5551().printByteBuffer(bb);
    }
}

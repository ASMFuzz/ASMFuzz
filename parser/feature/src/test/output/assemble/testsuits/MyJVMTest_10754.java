import java.nio.ByteBuffer;

public class MyJVMTest_10754 {

    static ByteBuffer dst = null;

    int read(ByteBuffer dst) {
        dst.put((byte) 0);
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10754().read(dst));
    }
}

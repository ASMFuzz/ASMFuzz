import java.nio.ByteBuffer;

public class MyJVMTest_8099 {

    static int y = 0;

    static ByteBuffer buff = null;

    int setY(int y) {
        buff.putInt(0, y);
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8099().setY(y);
    }
}

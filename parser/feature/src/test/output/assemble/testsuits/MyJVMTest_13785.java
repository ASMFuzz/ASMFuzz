import java.nio.ByteBuffer;

public class MyJVMTest_13785 {

    static int x = 8;

    static ByteBuffer buff = null;

    int setX(int x) {
        buff.putInt(0, x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13785().setX(x);
    }
}

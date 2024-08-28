import java.nio.ByteBuffer;

public class MyJVMTest_4409 {

    static int x = 2;

    static ByteBuffer buff = null;

    int setX(int x) {
        buff.putInt(0, x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4409().setX(x);
    }
}

import java.nio.ByteBuffer;

public class MyJVMTest_17669 {

    static int y = 5;

    static ByteBuffer buff = null;

    int setY(int y) {
        buff.putInt(0, y);
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17669().setY(y);
    }
}

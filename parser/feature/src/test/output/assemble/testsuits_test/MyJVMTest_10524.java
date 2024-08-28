import java.nio.ByteBuffer;

public class MyJVMTest_10524 {

    static ByteBuffer buff = null;

    int getX() {
        return buff.getInt(0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10524().getX());
    }
}

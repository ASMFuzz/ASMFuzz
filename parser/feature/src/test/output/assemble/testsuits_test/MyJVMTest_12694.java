import java.nio.ByteBuffer;

public class MyJVMTest_12694 {

    static ByteBuffer buff = null;

    int getY() {
        return buff.getInt(1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12694().getY());
    }
}

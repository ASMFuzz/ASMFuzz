import java.nio.ByteBuffer;

public class MyJVMTest_3365 {

    static ByteBuffer buff = null;

    int getY() {
        return buff.getInt(1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3365().getY());
    }
}

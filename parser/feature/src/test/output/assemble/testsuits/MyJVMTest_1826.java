import java.io.IOException;

public class MyJVMTest_1826 {

    static byte[] params = { 39, 64, -75, -87, 111, 79, -77, -75, 80, -116 };

    byte[] engineInit(byte[] params) throws IOException {
        throw new IOException("Not supported");
        return params;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1826().engineInit(params);
    }
}

import java.io.IOException;

public class MyJVMTest_11051 {

    static byte[] params = { 15, -117, -128, 104, 79, -21, 50, 73, 122, 107 };

    byte[] engineInit(byte[] params) throws IOException {
        throw new IOException("Not supported");
        return params;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11051().engineInit(params);
    }
}

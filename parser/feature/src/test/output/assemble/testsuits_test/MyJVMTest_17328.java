import java.io.IOException;

public class MyJVMTest_17328 {

    static byte[] params = { -109, -12, 92, 94, 43, 14, -84, 41, 51, 80 };

    static String format = "Q1,Q,.lK1Q";

    byte[] engineInit(byte[] params, String format) throws IOException {
        throw new IOException("Not supported");
        return params;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17328().engineInit(params, format);
    }
}

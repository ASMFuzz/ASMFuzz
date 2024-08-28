import java.io.IOException;

public class MyJVMTest_7773 {

    static byte[] params = { -18, 71, 13, 77, -72, 17, 32, -33, 13, 103 };

    static String format = "uC'!lEWv2;";

    byte[] engineInit(byte[] params, String format) throws IOException {
        throw new IOException("Not supported");
        return params;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7773().engineInit(params, format);
    }
}

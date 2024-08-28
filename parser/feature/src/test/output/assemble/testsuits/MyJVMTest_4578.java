import java.io.IOException;
import java.util.Arrays;

public class MyJVMTest_4578 {

    static String format = "=m\\/NAWkp{";

    byte[] engineGetEncoded(String format) throws IOException {
        throw new IOException("Not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4578().engineGetEncoded(format)));
    }
}

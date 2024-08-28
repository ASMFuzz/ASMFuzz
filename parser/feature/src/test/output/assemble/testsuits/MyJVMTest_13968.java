import java.io.IOException;
import java.util.Arrays;

public class MyJVMTest_13968 {

    static String format = "~v0wX\"q\\8%";

    byte[] engineGetEncoded(String format) throws IOException {
        throw new IOException("Not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13968().engineGetEncoded(format)));
    }
}

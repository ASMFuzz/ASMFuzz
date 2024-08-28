import java.io.IOException;
import java.util.Arrays;

public class MyJVMTest_17458 {

    byte[] engineGetEncoded() throws IOException {
        throw new IOException("Not supported");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17458().engineGetEncoded()));
    }
}

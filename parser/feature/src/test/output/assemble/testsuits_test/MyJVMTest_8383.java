import java.io.*;
import java.util.Arrays;

public class MyJVMTest_8383 {

    static BufferedInputStream myStream = null;

    static ByteArrayOutputStream bout = null;

    byte[] getOutputAsByteArray() {
        return bout.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8383().getOutputAsByteArray()));
    }
}

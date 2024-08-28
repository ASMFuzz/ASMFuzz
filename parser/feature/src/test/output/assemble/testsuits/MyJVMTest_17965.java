import java.io.*;
import java.util.Arrays;

public class MyJVMTest_17965 {

    static BufferedInputStream myStream = null;

    static ByteArrayOutputStream bout = null;

    byte[] getOutputAsByteArray() {
        return bout.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17965().getOutputAsByteArray()));
    }
}

import java.io.*;

public class MyJVMTest_17891 {

    static int outParam1 = 762;

    static OutputStream out = new ByteArrayOutputStream(outParam1);

    OutputStream doTest1(OutputStream out) throws Exception {
        byte[] b = null;
        try {
            out.write(b, 0, 32);
        } catch (NullPointerException npe) {
            System.err.println("SuccessFully completed null b test on " + out);
            return;
        }
        throw new RuntimeException(out + " Failed null b test");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17891().doTest1(out);
    }
}

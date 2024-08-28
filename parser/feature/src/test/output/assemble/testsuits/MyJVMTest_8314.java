import java.io.*;

public class MyJVMTest_8314 {

    static int outParam1 = 809;

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
        new MyJVMTest_8314().doTest1(out);
    }
}

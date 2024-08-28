import java.io.*;

public class MyJVMTest_15895 {

    static byte[] b = { 55, 69, -124, -88, -62, 49, 4, -3, 52, -47 };

    static int off = 0;

    static int len = 1005710633;

    static ByteArrayOutputStream baos = new ByteArrayOutputStream();

    int dotest(byte[] b, int off, int len, ByteArrayOutputStream baos) throws Exception {
        if (b != null) {
            System.err.println("ByteArrayOutStream.write -- b.length = " + b.length + " off = " + off + " len = " + len);
        } else {
            System.err.println("ByteArrayOutStream.write - b is null off = " + off + " len = " + len);
        }
        try {
            baos.write(b, off, len);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException is thrown -- OKAY");
        } catch (NullPointerException e) {
            System.err.println("NullPointerException is thrown -- OKAY");
        } catch (Throwable e) {
            throw new RuntimeException("Unexpected Exception is thrown");
        }
        return off;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15895().dotest(b, off, len, baos);
    }
}

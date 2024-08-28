import java.io.*;

public class MyJVMTest_6411 {

    static byte[] b = { -41, 74, -111, 22, 46, -38, 33, -42, -121, -20 };

    static int off = 975940447;

    static int len = 0;

    static int baosParam1 = 877;

    static ByteArrayOutputStream baos = new ByteArrayOutputStream(baosParam1);

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
        new MyJVMTest_6411().dotest(b, off, len, baos);
    }
}

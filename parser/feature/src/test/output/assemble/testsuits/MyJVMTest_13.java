import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_13 {

    static byte[] data = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };

    static File outFile = null;

    void doFileOutputStream() throws Exception {
        System.out.println("--------FileOutputStream Test Started----------");
        FileOutputStream fos1 = new FileOutputStream(outFile);
        FileDescriptor fd = fos1.getFD();
        FileOutputStream fos2 = new FileOutputStream(fd);
        fos1 = null;
        System.gc();
        Thread.sleep(200);
        fos2.write(data);
        System.out.println("wrote:" + data.length + " bytes to fos2");
        fos2.close();
        System.out.println("--------FileOutputStream Test Over----------");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13().doFileOutputStream();
    }
}

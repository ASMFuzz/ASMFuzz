import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_7970 {

    static byte[] data = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };

    static File inFile = null;

    static File outFile = null;

    void doRandomAccessFile() throws Exception {
        System.out.println("--------RandomAccessFile Read Test Started----------");
        RandomAccessFile raf = new RandomAccessFile(inFile, "r");
        FileDescriptor fd = raf.getFD();
        FileInputStream fis = new FileInputStream(fd);
        fis = null;
        int ret = 0;
        System.gc();
        Thread.sleep(50);
        while ((ret = raf.read()) != -1) {
            System.out.println("read from raf:" + ret);
        }
        raf.close();
        Thread.sleep(200);
        System.out.println("--------RandomAccessFile Write Test Started----------");
        System.out.println();
        raf = new RandomAccessFile(outFile, "rw");
        fd = raf.getFD();
        FileOutputStream fos = new FileOutputStream(fd);
        fos = null;
        System.gc();
        Thread.sleep(200);
        raf.write(data);
        System.out.println("wrote:" + data.length + " bytes to raf");
        raf.close();
        System.out.println("--------RandomAccessFile Write Test Over----------");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7970().doRandomAccessFile();
    }
}

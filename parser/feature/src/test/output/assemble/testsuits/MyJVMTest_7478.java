import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_7478 {

    static File inFile = null;

    void doFileInputStream() throws Exception {
        FileInputStream fis1 = new FileInputStream(inFile);
        FileDescriptor fd = fis1.getFD();
        FileInputStream fis2 = new FileInputStream(fd);
        fis1 = null;
        int ret = 0;
        System.gc();
        Thread.sleep(200);
        while ((ret = fis2.read()) != -1) {
            System.out.println("read from fis2:" + ret);
        }
        fis2.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7478().doFileInputStream();
    }
}

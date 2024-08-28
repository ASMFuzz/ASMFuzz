import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_10187 {

    void bug6577466() throws Exception {
        for (int c = Character.MIN_VALUE; c <= Character.MAX_VALUE; c++) {
            if (!Character.isDefined((char) c))
                continue;
            String s = String.valueOf((char) c);
            byte[] bb = null;
            bb = s.getBytes("x-IBM970");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10187().bug6577466();
    }
}

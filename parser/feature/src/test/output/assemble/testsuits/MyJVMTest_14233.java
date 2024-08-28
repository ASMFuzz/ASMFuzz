import java.io.*;

public class MyJVMTest_14233 {

    static int length = 512;

    String createFileName(int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) array[i] = (char) ('0' + (i % 10));
        return new String(array);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14233().createFileName(length));
    }
}

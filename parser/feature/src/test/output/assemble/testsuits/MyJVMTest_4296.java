import java.io.*;

public class MyJVMTest_4296 {

    static int b = 8;

    static boolean broken = false;

    int write(int b) throws IOException {
        if (broken) {
            throw new OriginalIOException();
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4296().write(b);
    }
}

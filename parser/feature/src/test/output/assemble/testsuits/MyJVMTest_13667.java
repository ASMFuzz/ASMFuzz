import java.io.*;

public class MyJVMTest_13667 {

    static int b = 0;

    static boolean broken = false;

    int write(int b) throws IOException {
        if (broken) {
            throw new OriginalIOException();
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13667().write(b);
    }
}

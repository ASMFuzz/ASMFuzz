import java.io.*;

public class MyJVMTest_16082 {

    static int stream = 0;

    PrintStream getStream() {
        if (stream == 1) {
            return System.out;
        } else if (stream == 2) {
            return System.err;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16082().getStream());
    }
}
